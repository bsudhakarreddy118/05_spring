package com.learn.contactservice.exceptions;

//@ResponseStatus(code = HttpStatus.CONFLICT, reason = "Contacts Already exists")
public class ContactExistsException extends Exception{
    public ContactExistsException(String message) {
        super(message);
    }
}
