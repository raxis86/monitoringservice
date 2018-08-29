package com.offsidegaming.monitoringapplication.services.session;

public class SessionContextException extends Exception {

    private static final String MESSAGE = "Receiving session error";

    public SessionContextException(Throwable cause) {
        super(MESSAGE, cause);
    }

    public SessionContextException() {
        super(MESSAGE);
    }
}