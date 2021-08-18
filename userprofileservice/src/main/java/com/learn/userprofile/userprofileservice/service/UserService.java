package com.learn.userprofile.userprofileservice.service;

import com.learn.userprofile.userprofileservice.exceptions.InvalidCredetialsException;
import com.learn.userprofile.userprofileservice.exceptions.UserExistsException;
import com.learn.userprofile.userprofileservice.exceptions.UserNotFoundException;
import com.learn.userprofile.userprofileservice.model.User;
import com.learn.userprofile.userprofileservice.model.UserCredentials;

public interface UserService {

    User registerUser(User newUser) throws UserExistsException;

    boolean authenticateUser(UserCredentials credentials) throws InvalidCredetialsException, UserNotFoundException;
}
