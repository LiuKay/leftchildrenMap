package org.leftchildren.exception;

/**
 * Created by kay on 2017/5/2.
 */
public class RepeatApplyException extends ApplyException{
    public RepeatApplyException(String message) {
        super(message);
    }

    public RepeatApplyException(String message, Throwable cause) {
        super(message, cause);
    }
}
