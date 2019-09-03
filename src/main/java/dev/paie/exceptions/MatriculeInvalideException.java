package dev.paie.exceptions;

public class MatriculeInvalideException extends RuntimeException {

    public MatriculeInvalideException() {
        super();
    }

    public MatriculeInvalideException(String message) {
        super(message);
    }

    public MatriculeInvalideException(String message, Throwable cause) {
        super(message, cause);
    }

    public MatriculeInvalideException(Throwable cause) {
        super(cause);
    }

    protected MatriculeInvalideException(String message, Throwable cause, boolean enableSuppression,
                                         boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
