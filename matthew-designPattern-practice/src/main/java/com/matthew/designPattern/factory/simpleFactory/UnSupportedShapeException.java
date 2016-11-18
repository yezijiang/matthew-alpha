package com.matthew.designPattern.factory.simpleFactory;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-26 14:45
 */
public class UnSupportedShapeException extends RuntimeException {
    public UnSupportedShapeException() {
    }

    public UnSupportedShapeException(String message) {
        super(message);
    }

    public UnSupportedShapeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnSupportedShapeException(Throwable cause) {
        super(cause);
    }

    public UnSupportedShapeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
