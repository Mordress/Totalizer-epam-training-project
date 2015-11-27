package com.gmail.mordress.lab4.dao;

import com.gmail.mordress.lab4.domain.Horse;
import com.gmail.mordress.lab4.exceptions.PersistentException;

public interface HorseDao  extends Dao<Horse, Integer>{

    Horse find(String name) throws PersistentException;

}
