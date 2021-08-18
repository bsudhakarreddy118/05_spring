package com.learn.userprofile.userprofileservice.service;

import com.learn.userprofile.userprofileservice.exceptions.InvalidCredetialsException;
import com.learn.userprofile.userprofileservice.exceptions.UserExistsException;
import com.learn.userprofile.userprofileservice.exceptions.UserNotFoundException;
import com.learn.userprofile.userprofileservice.model.User;
import com.learn.userprofile.userprofileservice.model.UserCredentials;
import com.learn.userprofile.userprofileservice.respository.UserProfileRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private User userOne;
    private UserCredentials credentialsOne;

    @Mock
    private UserProfileRepository repository;

    @InjectMocks
    private UserServiceImpl service;


    @BeforeEach
    public void setup(){
        userOne = new User(1, "testname", "test@email.com", "testpass");
        credentialsOne = new UserCredentials("somemail@test.com", "passOne");
    }

    @Test
    public void givenUserDetailsWhenUserDoesNotExistThenReturnSaveUser() throws UserExistsException {
        //Configured the behaviour of Mock object
        when(repository.existsByEmail("test@email.com")).thenReturn(false);
        when(repository.save(any(User.class))).thenReturn(userOne);

        //Call to Service method, whcih will in turn invoke methods on Mock objects
        User user = service.registerUser(userOne);
        assertAll(
                ()->{assertNotNull(user);},
                ()->{assertTrue(user.getEmail().equals("test@email.com"));},
                ()->{assertTrue(user.getName().equals("testname"));}
        );

        //Verified when Mock calls were made by Service or not
        verify(repository,atLeastOnce()).existsByEmail(anyString());
        verify(repository,times(1)).save(any(User.class));
        verifyNoMoreInteractions(repository);
    }

    @Test
    public void givenUserDetailsWhenUserExistThenThrowException() throws UserExistsException {
        when(repository.existsByEmail("test@email.com")).thenReturn(true);
        assertThrows(UserExistsException.class, () -> service.registerUser(userOne));
        verify(repository).existsByEmail("test@email.com");
    }


    @Test
    public void givenUserCredentialsWhenValidThenReturnTrue() throws UserNotFoundException, InvalidCredetialsException {
        //test setup using mock
        when(repository.getUserByEmail(anyString()))
                .thenReturn(
                        Optional.of(new User(1, "testname", "somemail@test.com", "passOne")));
        //actual test
        assertTrue(service.authenticateUser(credentialsOne));
        verify(repository).getUserByEmail(anyString());
    }

    @Test
    public void givenUserCredentialsWhenDoesNotExistThenThrowException(){
        //test setup using mock
        when(repository.getUserByEmail(anyString()))
                .thenReturn(
                        Optional.empty());
        //actual test
        assertThrows(UserNotFoundException.class, () -> service.authenticateUser(credentialsOne));
        verify(repository).getUserByEmail(anyString());
    }



}