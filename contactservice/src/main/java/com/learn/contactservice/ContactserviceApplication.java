package com.learn.contactservice;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ContactserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactserviceApplication.class, args);
	}

//	public @Bean MongoClient mongoClient() {
//		return MongoClients.create("mongodb://localhost:27017");
//	}
//
//	@Bean
//	public	MongoTemplate mongoTemplate() {
//		return new MongoTemplate(mongoClient(), "mycontacts_db");
//	}

}
