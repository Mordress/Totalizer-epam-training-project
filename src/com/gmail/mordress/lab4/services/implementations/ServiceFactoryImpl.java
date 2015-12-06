package com.gmail.mordress.lab4.services.implementations;

import com.gmail.mordress.lab4.dao.interfaces.DaoFactory;
import com.gmail.mordress.lab4.exceptions.DaoException;
import com.gmail.mordress.lab4.exceptions.ServiceException;
import com.gmail.mordress.lab4.services.interfaces.BreedService;
import com.gmail.mordress.lab4.services.interfaces.Service;
import com.gmail.mordress.lab4.services.interfaces.ServiceFactory;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceFactoryImpl implements ServiceFactory {

    private static Logger logger = Logger.getLogger(ServiceFactoryImpl.class);

    private static final Map<Class<? extends Service>, Class<? extends ServiceImpl>> SERVICES = new ConcurrentHashMap<>();

    static {
        SERVICES.put(BreedService.class, BreedServiceImpl.class);
        //SERVICES.put(HorseService.class, HorseServiceImpl.class);
        //TODO OTHER
    }

    private DaoFactory factory;

    public ServiceFactoryImpl(DaoFactory factory) throws ServiceException {
        this.factory = factory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <Type extends Service> Type getService(Class<Type> key) throws ServiceException {
        Class<? extends ServiceImpl> value = SERVICES.get(key);
        if(value != null) {
            try {
                ServiceImpl service = value.newInstance();
                service.setDaoFactory(factory);
                return (Type)service;
            } catch(InstantiationException | IllegalAccessException e) {
                logger.error("It is impossible to instance service class", e);
                throw new ServiceException(e.getMessage(), e.getCause());
            }
        }
        return null;
    }

    @Override
    public void close() {
        factory.close();
    }
}
