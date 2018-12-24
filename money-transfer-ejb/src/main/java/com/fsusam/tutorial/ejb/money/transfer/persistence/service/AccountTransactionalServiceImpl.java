package com.fsusam.tutorial.ejb.money.transfer.persistence.service;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import com.fsusam.tutorial.jar.money.transfer.ejb.dao.CustomerDAO;
import com.fsusam.tutorial.jar.money.transfer.ejb.dao.TransactionDAO;
import com.fsusam.tutorial.jar.money.transfer.ejb.exception.ExceptionConstants;
import com.fsusam.tutorial.jar.money.transfer.ejb.exception.MoneyTransferException;
import com.fsusam.tutorial.jar.money.transfer.ejb.model.Account;
import com.fsusam.tutorial.jar.money.transfer.ejb.model.Transaction;
import com.fsusam.tutorial.jar.money.transfer.ejb.service.AccountTransactionalService;

@Transactional
@Stateless
public class AccountTransactionalServiceImpl implements AccountTransactionalService {

    @EJB(beanName = "CustomerDAOImpl")
    private CustomerDAO customerDAO;

    @EJB(beanName = "TransactionDAOImpl")
    private TransactionDAO transactionDAO;

    @Override
    public Account getAccountByIban(final String iban) throws MoneyTransferException {
        final List<Account> list = customerDAO.findAccountByIban(iban);
        if (list != null && list.size() > 0) {
            return list.get(0);
        } else {
            throw new MoneyTransferException(ExceptionConstants.ACCOUNT_NOT_FOUND.getDescription(), ExceptionConstants.ACCOUNT_NOT_FOUND.getCode());
        }
    }

    @Override
    public void updateAccountBalance(final Account sourceAccount, final Account targetAccount, final Double amount) {
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + amount);
        final Transaction transaction = new Transaction();
        transaction.setSourceAccount(sourceAccount);
        transaction.setTargetAccount(targetAccount);
        transaction.setTransactionTime(LocalDate.now());
        customerDAO.updateAccount(sourceAccount);
        customerDAO.updateAccount(targetAccount);
        transactionDAO.createTransaction(transaction);
    }

    @Override
    public void addAccount(final Account account) {
        customerDAO.addAccount(account);
    }
}
