package com.fsusam.tutorial.jar.money.transfer.ejb.service;

import javax.ejb.Remote;

import com.fsusam.tutorial.jar.money.transfer.ejb.exception.MoneyTransferException;
import com.fsusam.tutorial.jar.money.transfer.ejb.model.Account;

@Remote
public interface AccountTransactionalService {
    public boolean checkAccount(final String iban);

    public Account getAccountByIban(final String iban) throws MoneyTransferException;

    public void updateAccountBalance(final Account sourceAccount, final Account targetAccount, final Double amount);

    public void updateAccount(final Account account);

    public void addAccount(final Account account);
}
