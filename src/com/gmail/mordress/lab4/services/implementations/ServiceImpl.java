package com.gmail.mordress.lab4.services.implementations;

import com.gmail.mordress.lab4.dao.interfaces.DaoFactory;
import com.gmail.mordress.lab4.services.interfaces.Service;

abstract public class ServiceImpl implements Service {

    protected DaoFactory factory = null;

    public void setDaoFactory(DaoFactory factory) {
        this.factory = factory;
    }
}