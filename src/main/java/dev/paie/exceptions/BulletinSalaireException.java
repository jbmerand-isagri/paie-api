package dev.paie.exceptions;

public class BulletinSalaireException extends RuntimeException {

    public BulletinSalaireException() {
        super();
    }

    public BulletinSalaireException(String message) {
        super(message);
    }

    public BulletinSalaireException(String message, Throwable cause) {
        super(message, cause);
    }

    public BulletinSalaireException(Throwable cause) {
        super(cause);
    }

    protected BulletinSalaireException(String message, Throwable cause, boolean enableSuppression,
                                       boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
