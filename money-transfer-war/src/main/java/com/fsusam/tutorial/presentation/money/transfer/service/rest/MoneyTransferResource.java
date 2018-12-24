package com.fsusam.tutorial.presentation.money.transfer.service.rest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fsusam.tutorial.jar.money.transfer.ejb.exception.MoneyTransferException;
import com.fsusam.tutorial.jar.money.transfer.ejb.service.TransferService;
import com.fsusam.tutorial.jar.money.transfer.rest.util.ErrorResponse;
import com.fsusam.tutorial.jar.money.transfer.rest.util.TransferMoneyRequest;
import com.google.gson.Gson;

@Path("/")
@RequestScoped
public class MoneyTransferResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MoneyTransferResource.class);

    private static final Gson GSON = new Gson();

    @EJB
    private TransferService transferService;
    /*
     * @EJB private CustomerTransactionalServiceImpl customerService;
     */

    @Path("/test")
    @GET
    public Response testEndpoint() {
        //customerService.addCustomer();
        return Response.status(Response.Status.ACCEPTED).build();
    }

    @Path("/testAllCustomer")
    @GET
    public Response testAllCustomer() {
        return Response.status(Response.Status.ACCEPTED).build();
        /*
         * final ResponseCustomerList responseCustomerList = new ResponseCustomerList();
         * responseCustomerList.setList(customerService.findAllCustomers()); LOGGER.info("Customer List size: {}",
         * customerService.findAllCustomers().size()); return Response.status(Response.Status.OK).entity(new
         * Gson().toJson(responseCustomerList)).build();
         */
    }

    @Path("/transferMoney")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response transferMoney(final TransferMoneyRequest transferMoneyRequest) {
        try {
            LOGGER.info(transferMoneyRequest.toString());
            transferService.startTransferMoney(transferMoneyRequest.getSourceIban(), transferMoneyRequest.getTargetIban(),
                    transferMoneyRequest.getAmount());
            return Response.status(Response.Status.OK).build();
        } catch (final MoneyTransferException e) {
            return getErrorResponse(e, Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    private static Response getErrorResponse(final MoneyTransferException e, final Response.Status status) {
        final ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(String.valueOf(status.getStatusCode()));
        errorResponse.setCode(e.getCode());
        errorResponse.setMessage(e.getMessage());
        return Response.status(status).entity(new Gson().toJson(errorResponse)).build();
    }
}
