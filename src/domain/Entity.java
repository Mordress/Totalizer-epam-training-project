package domain;

import java.io.Serializable;

public abstract class Entity  implements Serializable {

    private Integer identity;

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null) {
            if(obj != this) {
                if(obj.getClass() == getClass() && identity != null) {
                    return identity.equals(((Entity)obj).identity);
                }
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return identity != null ? identity.hashCode() : 0;
    }
}
