package com.gmail.mordress.epamproject.exceptions;

/**
 * Exception, throwed if database can not execute request.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class PersistentException extends Exception {

    public PersistentException() {
        super();
    }

    public PersistentException(String message) {
        super(message);
    }

    public PersistentException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
