package com.gmail.mordress.lab4.services.impls;

import com.gmail.mordress.lab4.dao.interfaces.DaoFactory;
import com.gmail.mordress.lab4.services.ifaces.Service;

abstract public class ServiceImpl implements Service {

    protected DaoFactory factory = null;

    public void setDaoFactory(DaoFactory factory) {
        this.factory = factory;
    }
}