package com.gmail.mordress.lab4.action;

import com.gmail.mordress.lab4.services.implementations.ServiceFactoryImpl;
import com.gmail.mordress.lab4.services.interfaces.ServiceFactory;

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
