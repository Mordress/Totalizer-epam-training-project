package com.gmail.mordress.epamproject.services.ifaces;

import com.gmail.mordress.epamproject.exceptions.PersistentException;

/**
 * Provides access to service-classes for interact dao-classes.
 * @author Alexey Kardychko
 * @version 1.0
 */
public interface ServiceFactory {

    <Type extends Service> Type getService(Class<? extends Service> key) throws PersistentException;

    void close();
}