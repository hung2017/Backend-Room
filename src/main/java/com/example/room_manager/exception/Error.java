package com.example.room_manager.exception;

import lombok.Data;

import java.util.Date;
@Data
public class Error {
    private int statusCode;
    private String message;
    private Date timestamp;
}
