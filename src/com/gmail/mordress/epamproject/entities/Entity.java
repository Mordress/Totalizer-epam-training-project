package com.gmail.mordress.epamproject.entities;

import java.io.Serializable;

/**
 * Class-Entity, describes abstract entity.
 * @author Alexey Kardychko
 * @version 1.0
 */
public abstract class Entity  implements Serializable {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null) {
            if(obj != this) {
                if(obj.getClass() == getClass() && id != null) {
                    return id.equals(((Entity)obj).id);
                }
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
