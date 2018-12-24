package com.fsusam.tutorial.ejb.money.transfer.persistence.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.fsusam.tutorial.jar.money.transfer.ejb.exception.MoneyTransferException;
import com.fsusam.tutorial.jar.money.transfer.ejb.model.Account;
import com.fsusam.tutorial.jar.money.transfer.ejb.service.AccountTransactionalService;
import com.fsusam.tutorial.jar.money.transfer.ejb.service.TransferService;
import com.fsusam.tutorial.jar.money.transfer.ejb.utils.Validation;

@Stateless
public class TransferServiceImpl implements TransferService {

    @EJB(beanName = "AccountTransactionalServiceImpl")
    private AccountTransactionalService accountTransactionalService;

    @Override
    public void startTransferMoney(final String sourceIban, final String targetIban, final Double amount) throws MoneyTransferException {

        Validation.validateMissingParameter(sourceIban, targetIban, amount);

        Validation.validateAmount(amount);

        final Account sourceAccount = accountTransactionalService.getAccountByIban(sourceIban);

        final Account targetAccount = accountTransactionalService.getAccountByIban(targetIban);

        Validation.validateBalance(sourceAccount.getBalance());

        accountTransactionalService.updateAccountBalance(sourceAccount, targetAccount, amount);
    }
}
