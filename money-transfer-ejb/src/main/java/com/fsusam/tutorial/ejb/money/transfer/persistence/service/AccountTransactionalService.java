package com.fsusam.tutorial.ejb.money.transfer.persistence.service;

import javax.ejb.Remote;

import com.fsusam.tutorial.ejb.money.transfer.persistence.exception.MoneyTransferException;
import com.fsusam.tutorial.ejb.money.transfer.persistence.model.Account;

@Remote
public interface AccountTransactionalService {
    public boolean checkAccount(final String iban);

    public Account getAccountByIban(final String iban) throws MoneyTransferException;

    public void updateAccountBalance(final Account sourceAccount, final Account targetAccount, final Double amount);

    public void updateAccount(final Account account);

    public void addAccount(final Account account);
}
