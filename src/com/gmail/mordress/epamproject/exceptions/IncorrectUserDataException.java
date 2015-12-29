package com.gmail.mordress.epamproject.exceptions;

/**
 * Exception, throwed if user's input data is not valid.
 * @author Alexey Kardychko
 * @version 1.0
 */
public class IncorrectUserDataException extends Exception {

    public IncorrectUserDataException() {
        super();
    }

    public IncorrectUserDataException(String message) {
        super(message);
    }
}
