package com.myproject.orders.infrastructure.exceptions;

public class NotAuthorizedException extends RuntimeException {

    public NotAuthorizedException(String additionalContext) {
        super(additionalContext);
    }
}
