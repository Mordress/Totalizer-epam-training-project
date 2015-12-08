package com.gmail.mordress.lab4.services.interfaces;

import com.gmail.mordress.lab4.exceptions.ServiceException;

public interface ServiceFactory {
    <Type extends Service> Type getService(Class<? extends Service> key) throws ServiceException;

    void close();
}