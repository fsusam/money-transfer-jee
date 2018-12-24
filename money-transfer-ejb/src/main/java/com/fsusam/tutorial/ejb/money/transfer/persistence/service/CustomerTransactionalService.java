package com.fsusam.tutorial.ejb.money.transfer.persistence.service;

import java.util.List;

import javax.ejb.Remote;

import com.fsusam.tutorial.ejb.money.transfer.persistence.model.Account;
import com.fsusam.tutorial.ejb.money.transfer.persistence.model.Customer;

@Remote
public interface CustomerTransactionalService {
    public void addCustomer(final Customer customer);

    public List<Customer> getCustomerByIbanAndName(final String iban, final String name);

    public List<Account> getAccountByCustomerIdAndIban(final int customerId, final String iban);

    public List<Account> getCurrentBalanceByIban(final String iban);

}
