package com.fsusam.tutorial.jar.money.transfer.ejb.dao;

import javax.ejb.Remote;

import com.fsusam.tutorial.jar.money.transfer.ejb.model.Transaction;

@Remote
public interface TransactionDAO {
    public void createTransaction(final Transaction transaction);

}
