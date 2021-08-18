package com.learn.userprofile.userprofileservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.userprofile.userprofileservice.exceptions.UserExistsException;
import com.learn.userprofile.userprofileservice.model.User;
import com.learn.userprofile.userprofileservice.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserProfileController.class)
class UserProfileControllerTest {

    public static final String USERS_REGISTER_URL = "/api/v1/users/register";

    private User userOne;

    @MockBean
    private UserServiceImpl service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        userOne = new User(1, "testname", "test@email.com", "testpass");
    }

    @Test
    public void givenNewUserDetailsWhenUserDoesNotExistThenShouldReturnCreatedStatus() throws Exception {
       when(service.registerUser(any(User.class))).thenReturn(userOne);

       mockMvc.perform(post(USERS_REGISTER_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(userOne))
                        )
                        .andExpect(status().isCreated())
                        .andExpect(content().json(mapper.writeValueAsString(userOne)));
//                        .andExpect(jsonPath("$.email").value("test@email.com"));
//                      .andDo(MockMvcResultHandlers.print())

       verify(service).registerUser(any(User.class));
    }

    @Test
    public void givenNewUserDetailsWhenUserDoesExistsThenShouldReturnConflictStatus() throws Exception {
        when(service.registerUser(any(User.class))).thenThrow(UserExistsException.class);

        mockMvc.perform(post(USERS_REGISTER_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(userOne))
        ).andExpect(status().isConflict());
        verify(service).registerUser(any(User.class));
   }
}