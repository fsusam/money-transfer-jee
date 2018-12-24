package com.fsusam.tutorial.ejb.money.transfer.persistence.service;

import javax.ejb.Remote;

import com.fsusam.tutorial.ejb.money.transfer.persistence.exception.MoneyTransferException;

@Remote
public interface TransferService {
    public void startTransferMoney(final String sourceIban, final String targetIban, final Double amount) throws MoneyTransferException;
}
