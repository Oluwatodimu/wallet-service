package io.todimu.practice.ussdwallet.exception;

public class UserSuspendedException extends RuntimeException {

    public UserSuspendedException() {
        super();
    }

    public UserSuspendedException(String message) {
        super(message);
    }
}
