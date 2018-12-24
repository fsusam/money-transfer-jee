package com.fsusam.tutorial.ejb.money.transfer.persistence.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import com.fsusam.tutorial.ejb.money.transfer.persistence.dao.CustomerDAO;
import com.fsusam.tutorial.ejb.money.transfer.persistence.model.Account;
import com.fsusam.tutorial.ejb.money.transfer.persistence.model.Customer;

@Transactional
@Stateless
public class CustomerTransactionalServiceImpl implements CustomerTransactionalService {

    @EJB
    private CustomerDAO customerDAO;

    @Override
    public void addCustomer(final Customer customer) {
        customerDAO.addCustomer(customer);
    }

    @Override
    public List<Customer> getCustomerByIbanAndName(final String iban, final String name) {
        return customerDAO.findCustomerByIbanAndName(iban, name);
    }

    @Override
    public List<Account> getAccountByCustomerIdAndIban(final int customerId, final String iban) {
        return customerDAO.findAccountByCustomerIdAndIban(customerId, iban);
    }

    @Override
    public List<Account> getCurrentBalanceByIban(final String iban) {
        return customerDAO.findAccountByIban(iban);
    }

    public List<Customer> findAllCustomers() {
        return customerDAO.findAllCustomers();
    }
}
