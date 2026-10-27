package com.itacademy.nivel3.Exceptions;

public class SeatAlreadyEmptyException extends RuntimeException {
    public SeatAlreadyEmptyException(String message) {
        super(message);
    }
}
