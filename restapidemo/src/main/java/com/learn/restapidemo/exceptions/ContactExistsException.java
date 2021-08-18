package com.learn.restapidemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Contacts Already exists")
public class ContactExistsException extends Exception{
    public ContactExistsException(String message) {
        super(message);
    }
}
