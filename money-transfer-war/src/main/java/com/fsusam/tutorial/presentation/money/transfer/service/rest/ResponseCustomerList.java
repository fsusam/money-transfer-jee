package com.fsusam.tutorial.presentation.money.transfer.service.rest;

import java.util.List;

import com.fsusam.tutorial.jar.money.transfer.ejb.model.Customer;

public class ResponseCustomerList {
    private List<Customer> list;

    public List<Customer> getList() {
        return list;
    }

    public void setList(final List<Customer> list) {
        this.list = list;
    }
}
