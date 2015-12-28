package com.gmail.mordress.epamproject.action;

import com.gmail.mordress.epamproject.services.ifaces.ServiceFactory;

/**
 * Provides access action-classes to service-layer classes(throught service factory) for interact Controller with
 * model.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class ActionManagerFactoryImpl implements ActionManagerFactory {

    private ServiceFactory factory;

    public ActionManagerFactoryImpl(ServiceFactory factory) {
        this.factory = factory;
    }

    @Override
    public ActionManager getManager() {
        return new ActionManagerImpl(factory);
    }
}
