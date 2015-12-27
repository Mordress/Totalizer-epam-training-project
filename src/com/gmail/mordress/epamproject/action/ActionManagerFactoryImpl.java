package com.gmail.mordress.epamproject.action;

import com.gmail.mordress.epamproject.services.ifaces.ServiceFactory;

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
