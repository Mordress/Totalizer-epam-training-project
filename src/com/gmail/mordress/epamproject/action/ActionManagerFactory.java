package com.gmail.mordress.epamproject.action;

/**
 * Provides access action-classes to service-layer classes(throught service factory) for interact Controller with
 * model.
 * @author Alexey Kardychko
 * @version 1.0
 */
public interface ActionManagerFactory {

    public ActionManager getManager();
}
