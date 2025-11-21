package com.flightfluxapp.exception;


public class AvaliableSeatMoreThanTotal extends RuntimeException {
    public AvaliableSeatMoreThanTotal(String message) {
        super(message);
    }
}