package com.learn.userprofile.userprofileservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.userprofile.userprofileservice.model.User;
import com.learn.userprofile.userprofileservice.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
class UserprofileserviceITTests {
    public static final String USERS_REGISTER_URL = "/api/v1/users/register";

    private User userOne;


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

        mockMvc.perform(post(USERS_REGISTER_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(userOne))
        )
                .andExpect(status().isCreated())
                        .andExpect(jsonPath("$.email").value("test@email.com"));

    }
}
