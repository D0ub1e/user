package com.hkwy.model;

/**
 * Created by double on 16-12-14.
 */
public class UserException extends RuntimeException {
    public UserException() {
        super();
    }

    public UserException(String s) {
        super(s);
    }

    public UserException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UserException(Throwable throwable) {
        super(throwable);
    }
}
