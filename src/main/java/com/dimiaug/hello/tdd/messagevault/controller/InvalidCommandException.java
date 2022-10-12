package com.dimiaug.hello.tdd.messagevault.controller;

public class InvalidCommandException extends RuntimeException {
    public InvalidCommandException(String s) {
        super(s);
    }

    public InvalidCommandException(Exception nfe) {
        super(nfe);
    }
}
