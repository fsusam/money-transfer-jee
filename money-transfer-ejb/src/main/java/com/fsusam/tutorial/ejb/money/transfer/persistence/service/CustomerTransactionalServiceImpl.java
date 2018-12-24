package com.fsusam.tutorial.ejb.money.transfer.persistence.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import com.fsusam.tutorial.jar.money.transfer.ejb.dao.CustomerDAO;
import com.fsusam.tutorial.jar.money.transfer.ejb.model.Customer;
import com.fsusam.tutorial.jar.money.transfer.ejb.service.CustomerTransactionalService;

@Transactional
@Stateless
public class CustomerTransactionalServiceImpl implements CustomerTransactionalService {

    @EJB(beanName = "CustomerDAOImpl")
    private CustomerDAO customerDAO;

    @Override
    public void addCustomer(final Customer customer) {
        customerDAO.addCustomer(customer);
    }

    public List<Customer> findAllCustomers() {
        return customerDAO.findAllCustomers();
    }
}
