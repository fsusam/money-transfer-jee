package com.fsusam.tutorial.jar.money.transfer.ejb.dao;

import java.util.List;

import javax.ejb.Remote;

import com.fsusam.tutorial.jar.money.transfer.ejb.model.Account;
import com.fsusam.tutorial.jar.money.transfer.ejb.model.Customer;

@Remote
public interface CustomerDAO {

    public void addCustomer(final Customer customer);

    public void addAccount(final Account account);

    public List<Customer> findCustomerByIbanAndName(final String iban, final String name);

    public List<Account> findAccountByCustomerIdAndIban(final int customerId, final String iban);

    public List<Account> findAccountByIban(final String iban);

    public void updateAccount(final Account account);

    public List<Customer> findAllCustomers();
}
