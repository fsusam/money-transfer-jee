package com.fsusam.tutorial.integration.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fsusam.tutorial.jar.money.transfer.rest.util.ErrorResponse;
import com.fsusam.tutorial.jar.money.transfer.rest.util.TransferMoneyRequest;
import com.google.gson.Gson;

@RunWith(Arquillian.class)
public class MoneyTransferIT {
    private static final Logger LOGGER = LoggerFactory.getLogger(MoneyTransferIT.class);

    private static final Gson GSON = new Gson();

    @Test
    @RunAsClient
    @InSequence(1)
    public void transferMoney() throws IOException {
        final TransferMoneyRequest transferMoneyRequest = new TransferMoneyRequest();
        transferMoneyRequest.setAmount(new Double(100));
        transferMoneyRequest.setSourceIban("IE42AIBK11116455591111");
        transferMoneyRequest.setTargetIban("IE42AIBK22226455592222");

        // create HTTP Client
        final HttpClient httpClient = HttpClientBuilder.create().build();

        // Execute your request and catch response
        final HttpResponse response = httpClient.execute(generateTransferMoneyHttpRequest(transferMoneyRequest));

        assertEquals(200, response.getStatusLine().getStatusCode());
    }

    @Test
    @RunAsClient
    @InSequence(2)
    public void transferMoney_whenMissingParameterAmount() throws IOException {
        final TransferMoneyRequest transferMoneyRequest = new TransferMoneyRequest();
        transferMoneyRequest.setAmount(null);
        transferMoneyRequest.setSourceIban("IE42AIBK11116455591111");
        transferMoneyRequest.setTargetIban("IE42AIBK22226455592222");

        // create HTTP Client
        final HttpClient httpClient = HttpClientBuilder.create().build();

        // Execute your request and catch response
        final HttpResponse response = httpClient.execute(generateTransferMoneyHttpRequest(transferMoneyRequest));
        final ErrorResponse errorResponse = GSON.fromJson(EntityUtils.toString(response.getEntity()), ErrorResponse.class);

        assertEquals(500, response.getStatusLine().getStatusCode());
        assertEquals(new Integer(5), errorResponse.getCode());
    }

    @Test
    @RunAsClient
    @InSequence(3)
    public void transferMoney_whenMissingParameterSourceIban() throws IOException {
        final TransferMoneyRequest transferMoneyRequest = new TransferMoneyRequest();
        transferMoneyRequest.setAmount(new Double(100));
        transferMoneyRequest.setSourceIban(null);
        transferMoneyRequest.setTargetIban("IE42AIBK22226455592222");

        // create HTTP Client
        final HttpClient httpClient = HttpClientBuilder.create().build();

        // Execute your request and catch response
        final HttpResponse response = httpClient.execute(generateTransferMoneyHttpRequest(transferMoneyRequest));
        final ErrorResponse errorResponse = GSON.fromJson(EntityUtils.toString(response.getEntity()), ErrorResponse.class);

        assertEquals(500, response.getStatusLine().getStatusCode());
        assertEquals(new Integer(5), errorResponse.getCode());
    }

    @Test
    @RunAsClient
    @InSequence(4)
    public void transferMoney_whenMissingParameterTargetIban() throws IOException {
        final TransferMoneyRequest transferMoneyRequest = new TransferMoneyRequest();
        transferMoneyRequest.setAmount(new Double(100));
        transferMoneyRequest.setSourceIban("IE42AIBK11116455591111");
        transferMoneyRequest.setTargetIban(null);

        // create HTTP Client
        final HttpClient httpClient = HttpClientBuilder.create().build();

        // Execute your request and catch response
        final HttpResponse response = httpClient.execute(generateTransferMoneyHttpRequest(transferMoneyRequest));
        final ErrorResponse errorResponse = GSON.fromJson(EntityUtils.toString(response.getEntity()), ErrorResponse.class);

        assertEquals(500, response.getStatusLine().getStatusCode());
        assertEquals(new Integer(5), errorResponse.getCode());
    }

    @Test
    @RunAsClient
    @InSequence(5)
    public void transferMoney_whenAmountZero() throws IOException {
        final TransferMoneyRequest transferMoneyRequest = new TransferMoneyRequest();
        transferMoneyRequest.setAmount(new Double(0));
        transferMoneyRequest.setSourceIban("IE42AIBK11116455591111");
        transferMoneyRequest.setTargetIban("IE42AIBK22226455592222");

        // create HTTP Client
        final HttpClient httpClient = HttpClientBuilder.create().build();

        // Execute your request and catch response
        final HttpResponse response = httpClient.execute(generateTransferMoneyHttpRequest(transferMoneyRequest));
        final ErrorResponse errorResponse = GSON.fromJson(EntityUtils.toString(response.getEntity()), ErrorResponse.class);

        assertEquals(500, response.getStatusLine().getStatusCode());
        assertEquals(new Integer(4), errorResponse.getCode());
    }

    @Test
    @RunAsClient
    @InSequence(6)
    public void transferMoney_whenInsufficientBalance() throws IOException {
        final TransferMoneyRequest transferMoneyRequest = new TransferMoneyRequest();
        transferMoneyRequest.setAmount(new Double(100));
        transferMoneyRequest.setSourceIban("IE42AIBK11116455591111");
        transferMoneyRequest.setTargetIban("IE42AIBK22226455592222");

        // create HTTP Client
        final HttpClient httpClient = HttpClientBuilder.create().build();

        // Execute your request and catch response
        final HttpResponse response = httpClient.execute(generateTransferMoneyHttpRequest(transferMoneyRequest));
        final ErrorResponse errorResponse = GSON.fromJson(EntityUtils.toString(response.getEntity()), ErrorResponse.class);

        assertEquals(500, response.getStatusLine().getStatusCode());
        assertEquals(new Integer(3), errorResponse.getCode());
    }

    @Test
    @RunAsClient
    @InSequence(7)
    public void transferMoney_whenNotExistAccount() throws IOException {
        final TransferMoneyRequest transferMoneyRequest = new TransferMoneyRequest();
        transferMoneyRequest.setAmount(new Double(100));
        transferMoneyRequest.setSourceIban("IE42AIBK11116455590000");
        transferMoneyRequest.setTargetIban("IE42AIBK22226455592222"); // create HTTP Client final HttpClient httpClient =

        final HttpClient httpClient = HttpClientBuilder.create().build(); // Execute your request and catch response final HttpResponse response =
        httpClient.execute(generateTransferMoneyHttpRequest(transferMoneyRequest));

        final HttpResponse response = httpClient.execute(generateTransferMoneyHttpRequest(transferMoneyRequest));
        final ErrorResponse errorResponse = GSON.fromJson(EntityUtils.toString(response.getEntity()), ErrorResponse.class);

        assertEquals(500, response.getStatusLine().getStatusCode());
        assertEquals(new Integer(2), errorResponse.getCode());
    }

    private HttpPost generateTransferMoneyHttpRequest(final TransferMoneyRequest transferMoneyRequest) throws UnsupportedEncodingException {
        final StringEntity jsonPayload = new StringEntity(GSON.toJson(transferMoneyRequest, TransferMoneyRequest.class));

        // Create new getRequest with below mentioned URL
        final HttpPost httpPostRequest = new HttpPost("http://localhost:8080/tutorial/transferMoney");
        httpPostRequest.setHeader("Content-Type", ContentType.APPLICATION_JSON.toString());
        httpPostRequest.setHeader("Accept", ContentType.APPLICATION_JSON.toString());
        httpPostRequest.setEntity(jsonPayload);

        return httpPostRequest;
    }
}
