package com.example.room_manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
@ControllerAdvice
public class GlobaExepHandelr {
    @ExceptionHandler(RoomNotFoundExcep.class)
    public ResponseEntity<Error> handlerProductNotFoundException(RoomNotFoundExcep ex, WebRequest request){
        Error error = new Error();
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimestamp(new Date());

        return new ResponseEntity<Error>(error, HttpStatus.NOT_FOUND);
    }
}
