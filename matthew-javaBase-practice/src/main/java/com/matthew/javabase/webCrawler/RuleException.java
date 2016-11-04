package com.matthew.javabase.webCrawler;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-09-12 15:26
 */
public class RuleException extends RuntimeException{
    public RuleException() {
    }

    public RuleException(String message) {
        super(message);
    }

    public RuleException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuleException(Throwable cause) {
        super(cause);
    }
}
