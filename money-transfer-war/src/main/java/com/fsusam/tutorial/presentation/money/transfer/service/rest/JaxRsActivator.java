package com.fsusam.tutorial.presentation.money.transfer.service.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class JaxRsActivator extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>(2);
        classes.add(MoneyTransferResource.class);
        return classes;
    }
}
