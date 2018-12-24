package com.fsusam.tutorial.jar.money.transfer.ejb.service;

import javax.ejb.Remote;

import com.fsusam.tutorial.jar.money.transfer.ejb.model.Customer;

@Remote
public interface CustomerTransactionalService {
    public void addCustomer(final Customer customer);
}
