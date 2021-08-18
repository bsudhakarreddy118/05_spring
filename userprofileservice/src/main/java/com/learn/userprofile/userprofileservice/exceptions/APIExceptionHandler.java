package com.learn.userprofile.userprofileservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<?> handleUserExists(UserExistsException exception){
        return new ResponseEntity<>("User already exists with given email", HttpStatus.CONFLICT);
    }
}
