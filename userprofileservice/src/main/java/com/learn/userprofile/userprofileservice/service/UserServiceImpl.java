package com.learn.userprofile.userprofileservice.service;

import com.learn.userprofile.userprofileservice.exceptions.InvalidCredetialsException;
import com.learn.userprofile.userprofileservice.exceptions.UserExistsException;
import com.learn.userprofile.userprofileservice.exceptions.UserNotFoundException;
import com.learn.userprofile.userprofileservice.model.User;
import com.learn.userprofile.userprofileservice.model.UserCredentials;
import com.learn.userprofile.userprofileservice.respository.UserProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserProfileRepository repository;

    @Autowired
    public UserServiceImpl(UserProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public User registerUser(User newUser) throws UserExistsException {
        if (repository.existsByEmail(newUser.getEmail())) {
            logger.error("User Already exists with email {}", newUser.getEmail());
            throw new UserExistsException("User with email already exists");
        }
        logger.info("User registered successfully with email {}" , newUser.getEmail());
        return repository.save(newUser);
    }

    @Override
    public boolean authenticateUser(UserCredentials credentials) throws InvalidCredetialsException, UserNotFoundException {
        logger.debug("Accessing database for getting user credentials");
        Optional<User> userByEmail = repository.getUserByEmail(credentials.getEmail());
        if(userByEmail.isEmpty()){
            logger.error("User not found with email : {}", credentials.getEmail());
            throw new UserNotFoundException("User not Found");
        }
        User user = userByEmail.get();
        if(user.getPassword().equals(credentials.getPassword())){
            logger.info("User authenticated successfully");
            return true;
        }else {
            logger.error("Password mismatch for user with email : {}", credentials.getEmail());
            throw new InvalidCredetialsException("Credentials Mismatch");
        }

    }
}
