package io.todimu.practice.ussdwallet.exception;

public class UserNotActivatedException extends RuntimeException {

    public UserNotActivatedException() {
        super();
    }

    public UserNotActivatedException(String message) {
        super(message);
    }
}
