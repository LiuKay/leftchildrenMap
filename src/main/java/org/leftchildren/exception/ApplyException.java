package org.leftchildren.exception;

/**
 * Created by kay on 2017/5/2.
 */
public class ApplyException extends RuntimeException{
    public ApplyException(String message) {
        super(message);
    }

    public ApplyException(String message, Throwable cause) {
        super(message, cause);
    }
}
