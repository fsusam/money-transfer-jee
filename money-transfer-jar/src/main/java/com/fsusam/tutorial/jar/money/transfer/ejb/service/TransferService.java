package com.fsusam.tutorial.jar.money.transfer.ejb.service;

import javax.ejb.Remote;

import com.fsusam.tutorial.jar.money.transfer.ejb.exception.MoneyTransferException;

@Remote
public interface TransferService {
    public void startTransferMoney(final String sourceIban, final String targetIban, final Double amount) throws MoneyTransferException;
}
