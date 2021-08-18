package com.learn.userprofile.userprofileservice.controller;

import com.learn.userprofile.userprofileservice.exceptions.InvalidCredetialsException;
import com.learn.userprofile.userprofileservice.exceptions.UserExistsException;
import com.learn.userprofile.userprofileservice.exceptions.UserNotFoundException;
import com.learn.userprofile.userprofileservice.model.User;
import com.learn.userprofile.userprofileservice.model.UserCredentials;
import com.learn.userprofile.userprofileservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")

public class UserProfileController {

    private Logger logger = LoggerFactory.getLogger(UserProfileController.class);

    private UserService service;

    @Autowired
    public UserProfileController(UserService service) {
        this.service = service;
    }

    @PostMapping("register")
    public ResponseEntity<User> registerUser(@RequestBody User newUser) throws UserExistsException {
        return new ResponseEntity<>(service.registerUser(newUser), HttpStatus.CREATED);
    }


    @PostMapping("login")
    public ResponseEntity<String> loginUser(@RequestBody UserCredentials credentials) throws UserNotFoundException, InvalidCredetialsException {
        boolean valid = service.authenticateUser(credentials);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
