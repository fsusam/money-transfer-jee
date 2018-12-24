package com.fsusam.tutorial.ejb.money.transfer.persistence.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fsusam.tutorial.ejb.money.transfer.persistence.model.Transaction;

@Stateless
public class TransactionDAO {
    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager em;

    public void createTransaction(final Transaction transaction) {
        em.persist(transaction);
    }

}
