package com.LaundryRoom.app.Exceptions;

public class InvalidUsernamePasswordException extends Exception {
    public InvalidUsernamePasswordException() {
        super("Username and/or password is invalid.");
    }
}
