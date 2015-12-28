package com.gmail.mordress.epamproject.action;

import com.gmail.mordress.epamproject.entities.Role;
import com.gmail.mordress.epamproject.entities.User;
import com.gmail.mordress.epamproject.exceptions.PersistentException;
import com.gmail.mordress.epamproject.services.ifaces.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class incapsulate requested action, which matches URI, requested by front-end.
 * @author Alexey Kardychko
 * @version 1.0
 */
public abstract class Action {

    protected ServiceFactory factory;

    /** This field contains set of roles, possible for that authorized user */
    private Set<Role> allowRoles = new HashSet<>();

    private User authorizedUser;

    private String name;

    public Set<Role> getAllowRoles() {
        return allowRoles;
    }

    public void setAllowRoles(Set<Role> allowRoles) {
        this.allowRoles = allowRoles;
    }

    public User getAuthorizedUser() {
        return authorizedUser;
    }

    public void setAuthorizedUser(User authorizedUser) {
        this.authorizedUser = authorizedUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFactory(ServiceFactory factory) {
        this.factory = factory;
    }

    /** Execute commands, which needs for formation jsp, and pass contorls to next servlet or to jsp
     * @param request - HttpServletRequest
     * @param response - HttpServletResponse
     * @return {@link Action.Forward}
     * @throws PersistentException - if service and dao layers produce this exception */
    public abstract Action.Forward exec(HttpServletRequest request, HttpServletResponse response) throws PersistentException;

    /**
     * This class incapsulate passing controls between servlets and/or jsp.
     * @author Alexey Kardychko
     * @version 1.0
     */
    public static class Forward {

        /** This field contains URI with next servlet or jsp */
        private String forward;

        private boolean redirect;

        private Map<String, Object> attributes = new HashMap<>();

        public Forward(String forward, boolean redirect) {
            this.forward = forward;
            this.redirect = redirect;
        }

        public Forward(String forward) {
            this(forward, true);
        }

        public String getForward() {
            return forward;
        }

        public void setForward(String forward) {
            this.forward = forward;
        }

        public boolean isRedirect() {
            return redirect;
        }

        public void setRedirect(boolean redirect) {
            this.redirect = redirect;
        }

        public Map<String, Object> getAttributes() {
            return attributes;
        }
    }
}
