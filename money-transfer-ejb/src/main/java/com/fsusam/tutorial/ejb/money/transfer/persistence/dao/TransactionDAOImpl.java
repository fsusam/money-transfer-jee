package com.fsusam.tutorial.ejb.money.transfer.persistence.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.fsusam.tutorial.jar.money.transfer.ejb.dao.TransactionDAO;
import com.fsusam.tutorial.jar.money.transfer.ejb.model.Transaction;

@Stateless
public class TransactionDAOImpl implements TransactionDAO {
    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager em;

    @Override
    public void createTransaction(final Transaction transaction) {
        em.persist(transaction);
    }

}
