package com.learn.contactservice.repository;

import com.learn.contactservice.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends MongoRepository<Contact, String> {

    @Query("{category: ?0}")
    List<Contact> findByCategory(String category);

    Optional<Contact> findByEmail(String email);

    List<Contact> findByUserEmail(String email);

}
