package com.gmail.mordress.epamproject.services.impls;

import com.gmail.mordress.epamproject.dao.interfaces.DaoFactory;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.*;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceFactoryImpl implements ServiceFactory {

    private static Logger logger = Logger.getLogger(ServiceFactoryImpl.class);

    private static final Map<Class<? extends Service>, Class<? extends ServiceImpl>> SERVICES = new ConcurrentHashMap<>();

    static {
        SERVICES.put(BreedService.class, BreedServiceImpl.class);
        SERVICES.put(HorseService.class, HorseServiceImpl.class);
        SERVICES.put(RaceService.class, RaceServiceImpl.class);
        SERVICES.put(UserService.class, UserServiceImpl.class);
        SERVICES.put(HorseRaceService.class, HorseRaceServiceImpl.class);
        SERVICES.put(BetService.class, BetServiceImpl.class);
    }

    private DaoFactory factory;

    public ServiceFactoryImpl(final DaoFactory factory) throws PersistentException {
        this.factory = factory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <Type extends Service> Type getService(Class<? extends Service> key) throws PersistentException {
        Class<? extends ServiceImpl> value = SERVICES.get(key);
        if(value != null) {
            try {
                ServiceImpl service = value.newInstance();
                service.setDaoFactory(factory);
                return (Type)service;
            } catch(InstantiationException | IllegalAccessException e) {
                logger.error("It is impossible to instance service class", e);
                throw new PersistentException(e.getMessage(), e.getCause());
            }
        }
        return null;
    }

    @Override
    public void close() {
        factory.close();
    }
}
