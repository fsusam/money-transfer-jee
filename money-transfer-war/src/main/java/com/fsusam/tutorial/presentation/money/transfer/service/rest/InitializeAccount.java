package com.fsusam.tutorial.presentation.money.transfer.service.rest;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fsusam.tutorial.jar.money.transfer.ejb.model.Account;
import com.fsusam.tutorial.jar.money.transfer.ejb.model.Customer;
import com.fsusam.tutorial.jar.money.transfer.ejb.service.AccountTransactionalService;
import com.fsusam.tutorial.jar.money.transfer.ejb.service.CustomerTransactionalService;

@Startup
@Singleton
public class InitializeAccount {
    private static final Logger LOGGER = LoggerFactory.getLogger(InitializeAccount.class);

    private String status;

    @EJB
    private CustomerTransactionalService customerService;

    @EJB
    private AccountTransactionalService accountService;

    @PostConstruct
    void init() {
        addSampleCustomerAndAccount();
    }

    private void addSampleCustomerAndAccount() {
        final Customer customer1 = new Customer();
        final Account account1 = new Account();
        customer1.setName("CUSTOMER1");
        customerService.addCustomer(customer1);
        account1.setIban("IE42AIBK11116455591111");
        account1.setBalance(new Double(100));
        account1.setCustomer(customer1);
        accountService.addAccount(account1);

        final Customer customer2 = new Customer();
        final Account account2 = new Account();
        customer2.setName("CUSTOMER2");
        customerService.addCustomer(customer2);
        account2.setIban("IE42AIBK22226455592222");
        account2.setBalance(new Double(0));
        account2.setCustomer(customer2);
        accountService.addAccount(account2);

        LOGGER.info("Sample accounts were generated: Customers[{},{}] ", customer1.getName(), customer2.getName());

    }
}
