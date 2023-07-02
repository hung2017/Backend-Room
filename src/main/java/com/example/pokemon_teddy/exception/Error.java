package com.example.pokemon_teddy.exception;

import lombok.Data;

import java.util.Date;
@Data
public class Error {
    private int statusCode;
    private String message;
    private Date timestamp;
}
