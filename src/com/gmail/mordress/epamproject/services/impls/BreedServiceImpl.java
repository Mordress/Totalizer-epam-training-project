package com.gmail.mordress.epamproject.services.impls;

import com.gmail.mordress.epamproject.dao.interfaces.BreedDao;
import com.gmail.mordress.epamproject.entities.Breed;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.BreedService;
import java.util.List;

/**
 * Provides operations for breed-interaction with dao-layer.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class BreedServiceImpl extends ServiceImpl implements BreedService {

    /** Returns founded by name breed instance.
     * @param name - breed's name.
     * @return Breed instance.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    @Override
    public Breed findByName(String name) throws PersistentException {
        BreedDao dao = factory.createDao(BreedDao.class);
        return dao.findByName(name);
    }

    /** Returns all possible breeds.
     * @return List of Breeds.
     * @throws PersistentException - if dao-layer can't successful complete this operation. */
    @Override
    public List<Breed> getAllBreeds() throws PersistentException {
        BreedDao dao = factory.createDao(BreedDao.class);
        return dao.getAllBreeds();
    }

    /** Saves changes to breed, or create new breed.
     * @param breed - changed/new breed.
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    @Override
    public void save(Breed breed) throws PersistentException {
        BreedDao dao = factory.createDao(BreedDao.class);
        if (breed.getId() != null) {
            dao.update(breed);
        } else {
            breed.setId(dao.create(breed));
        }
    }

    /** Deletes breed by id.
     * @param id - breed's id.
     * @throws PersistentException - if dao-layer can't successful complete this operation.
     */
    @Override
    public void delete(Integer id) throws PersistentException {
        BreedDao dao = factory.createDao(BreedDao.class);
        dao.delete(id);
    }
}
