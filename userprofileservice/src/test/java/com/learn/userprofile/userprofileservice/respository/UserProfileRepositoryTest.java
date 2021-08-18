package com.learn.userprofile.userprofileservice.respository;

import com.learn.userprofile.userprofileservice.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserProfileRepositoryTest {

    @Autowired
    private UserProfileRepository repository;

    @BeforeEach
    public void setup(){
        User user1 = new User(0, "Charlie", "charlie@mail.com", "pass456");
        repository.save(user1);
    }

    @Test
    public void givenUserExistsinDBThenShouldReturnTrue() {
         assertTrue(repository.existsByEmail("charlie@mail.com"), "User does not exist in Database");
    }

    @Test
    public void givenUserDoesNotExistsinDBThenShouldReturnFalse() {
        assertFalse(repository.existsByEmail("john@mail.com"), "User does not exist in Database");
    }

    @Test
    public void givenUserEmailWhenUserExistsThenReturnOptionalWithUser() {
        Optional<User> optionalUser = repository.findByEmail("charlie@mail.com");
        assertTrue(optionalUser.isPresent());
        User user = optionalUser.get();
        assertEquals("Charlie", user.getName());
    }

    @Test
    public void givenUserEmailWhenUserDoesntExistThenReturnEmptyOptional() {
        Optional<User> optionalUser = repository.findByEmail("john@mail.com");
        assertTrue(optionalUser.isEmpty());
    }

}