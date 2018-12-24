package com.fsusam.tutorial.jar.money.transfer.ejb.service;

import javax.ejb.Remote;

import com.fsusam.tutorial.jar.money.transfer.ejb.model.Transaction;

@Remote
public interface TransferTransactionalService {
    public void createTransaction(final Transaction transaction);

}
