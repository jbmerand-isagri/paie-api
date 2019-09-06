package dev.paie.exceptions;

public class AuthentificationException extends RuntimeException {

    public AuthentificationException() {
        super();
    }

    public AuthentificationException(String message) {
        super(message);
    }

    public AuthentificationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthentificationException(Throwable cause) {
        super(cause);
    }

    protected AuthentificationException(String message, Throwable cause, boolean enableSuppression,
                                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
