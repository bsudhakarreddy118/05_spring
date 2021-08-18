package com.learn.contactservice.repository;

import com.learn.contactservice.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Contact getContactById(String id){

        return mongoTemplate.findById(id,Contact.class, "contact");
    }

}
