package com.example.room.exception;

public class RoomNotFoundExcep extends RuntimeException {
    private static final long serialVerisionUID = 1;

    public RoomNotFoundExcep(String message) {
        super(message);
    }
}
