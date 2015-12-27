package com.gmail.mordress.epamproject.services.ifaces;

import com.gmail.mordress.epamproject.exceptions.PersistentException;

public interface ServiceFactory {
    <Type extends Service> Type getService(Class<? extends Service> key) throws PersistentException;

    void close();
}