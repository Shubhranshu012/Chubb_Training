package com.flightfluxapp.exception;



public class ExceptionDueToSeat extends RuntimeException {
    public ExceptionDueToSeat(String message) {
        super(message);
    }
}