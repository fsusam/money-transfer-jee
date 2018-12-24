package com.fsusam.tutorial.ejb.money.transfer.persistence.service;

import javax.ejb.Remote;

import com.fsusam.tutorial.ejb.money.transfer.persistence.model.Transaction;

@Remote
public interface TransferTransactionalService {
    public void createTransaction(final Transaction transaction);

}
