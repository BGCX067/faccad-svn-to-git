package com.sickfar.faccad.annotation;

/**
 * Created with IntelliJ IDEA.
 *
 * @author sickfar
 */
public class NoPossibleUpdateMethodsAnnotatedException extends Exception {

    public NoPossibleUpdateMethodsAnnotatedException() {
        super();
    }

    public NoPossibleUpdateMethodsAnnotatedException(String message) {
        super(message);
    }

    public NoPossibleUpdateMethodsAnnotatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPossibleUpdateMethodsAnnotatedException(Throwable cause) {
        super(cause);
    }
}
