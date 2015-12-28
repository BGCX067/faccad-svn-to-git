package com.sickfar.faccad.module;

/**
 * Created with IntelliJ IDEA.
 * User: sickfar
 * Date: 03.03.13
 * Time: 22:00
 * To change this template use File | Settings | File Templates.
 */
public class ModuleException extends Exception {
    private int errorCode = UNKNOWN;

    public static final int INSTANTIATION = 0;
    public static final int ACCESS = 1;
    public static final int UNKNOWN = -1;

    public ModuleException() {
        super();
    }

    public ModuleException(String message) {
        super(message);
    }

    public ModuleException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModuleException(Throwable cause) {
        super(cause);
    }

    public ModuleException(int errorCode) {
        this.errorCode = errorCode;
    }

    public ModuleException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ModuleException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ModuleException(Throwable cause, int errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        switch (errorCode) {
            case INSTANTIATION:
                return "Module instantiation error: " + super.getMessage();
            case ACCESS:
                return "Module access exception: " + super.getMessage();
            default:
                return super.getMessage();
        }
    }

    public int getErrorCode() {
        return errorCode;
    }
}
