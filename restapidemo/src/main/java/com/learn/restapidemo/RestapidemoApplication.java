package com.learn.restapidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication  //@Configuration , @ComponentScan @EnableAutoConfiguration
public class RestapidemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapidemoApplication.class, args);
	}

}
