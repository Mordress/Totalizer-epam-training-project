package com.gmail.mordress.epamproject.services.impls;

import com.gmail.mordress.epamproject.dao.interfaces.DaoFactory;
import com.gmail.mordress.epamproject.services.ifaces.Service;
/**
 * Common abstract class to interact with dao-layer.
 * @author Alexey Kardychko
 * @version 1.0
 */
abstract public class ServiceImpl implements Service {

    protected DaoFactory factory = null;

    public void setDaoFactory(DaoFactory factory) {
        this.factory = factory;
    }
}