package com.gmail.mordress.epamproject.services.impls;

import com.gmail.mordress.epamproject.dao.interfaces.DaoFactory;
import com.gmail.mordress.epamproject.services.ifaces.Service;

abstract public class ServiceImpl implements Service {

    protected DaoFactory factory = null;

    public void setDaoFactory(DaoFactory factory) {
        this.factory = factory;
    }
}