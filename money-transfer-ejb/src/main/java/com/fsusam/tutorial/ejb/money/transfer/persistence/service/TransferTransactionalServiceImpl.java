package com.fsusam.tutorial.ejb.money.transfer.persistence.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import com.fsusam.tutorial.ejb.money.transfer.persistence.dao.TransactionDAO;
import com.fsusam.tutorial.ejb.money.transfer.persistence.model.Transaction;

@Transactional
@Stateless
public class TransferTransactionalServiceImpl implements TransferTransactionalService {

    @EJB
    private TransactionDAO transactionDAO;

    @Override
    public void createTransaction(final Transaction transaction) {
        transactionDAO.createTransaction(transaction);
    }
}
