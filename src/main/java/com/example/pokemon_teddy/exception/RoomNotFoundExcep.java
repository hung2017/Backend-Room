package com.example.pokemon_teddy.exception;

public class RoomNotFoundExcep extends RuntimeException {
    private static final long serialVerisionUID = 1;

    public RoomNotFoundExcep(String message) {
        super(message);
    }
}
