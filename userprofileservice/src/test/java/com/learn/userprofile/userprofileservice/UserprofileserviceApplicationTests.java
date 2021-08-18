package com.learn.userprofile.userprofileservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.userprofile.userprofileservice.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
class UserprofileserviceApplicationTests {

    public static final String USERS_REGISTER_URL = "http://localhost:9000/api/v1/users/register";

    private User userOne;

    @BeforeEach
    void setUp() {
        userOne = new User(1, "testname", "test@email.com", "testpass");
    }

//    @Test
    void sampleTest() throws Exception {
		User user = new RestTemplate().postForObject(USERS_REGISTER_URL, userOne, User.class);
		assertNotNull(user);
    }

}
