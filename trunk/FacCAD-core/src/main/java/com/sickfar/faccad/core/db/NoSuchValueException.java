package com.sickfar.faccad.core.db;


/**
 * Created with IntelliJ IDEA.
 * User: sickfar
 * Date: 24.03.13
 * Time: 17:46
 * To change this template use File | Settings | File Templates.
 */
public class NoSuchValueException extends Exception {
    public NoSuchValueException() {
        super();    //To change body of overridden methods use File | Settings | File Templates.
    }

    public NoSuchValueException(Throwable cause) {
        super(cause);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public NoSuchValueException(String reason, Throwable cause) {
        super(reason, cause);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public NoSuchValueException(String message) {
        super(message);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
