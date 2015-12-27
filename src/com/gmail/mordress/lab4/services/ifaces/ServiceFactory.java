package com.gmail.mordress.lab4.services.ifaces;

import com.gmail.mordress.lab4.exceptions.PersistentException;

public interface ServiceFactory {
    <Type extends Service> Type getService(Class<? extends Service> key) throws PersistentException;

    void close();
}