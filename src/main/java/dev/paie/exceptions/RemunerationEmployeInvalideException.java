package dev.paie.exceptions;

public class RemunerationEmployeInvalideException extends RuntimeException {

    public RemunerationEmployeInvalideException() {
        super();
    }

    public RemunerationEmployeInvalideException(String message) {
        super(message);
    }

    public RemunerationEmployeInvalideException(String message, Throwable cause) {
        super(message, cause);
    }

    public RemunerationEmployeInvalideException(Throwable cause) {
        super(cause);
    }

    protected RemunerationEmployeInvalideException(String message, Throwable cause, boolean enableSuppression,
                                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
