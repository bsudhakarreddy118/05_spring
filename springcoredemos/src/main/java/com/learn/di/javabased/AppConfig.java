package com.learn.di.javabased;

import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan(basePackages = "com.learn.di.annotationbased")
//@ImportResource("classpath:beans.xml")
public class AppConfig {

    @Bean
    @Scope("singleton")

    public UserDaoImpl1 dao1(){
        return new UserDaoImpl1("user1", "pass1", "URLONE");
    }

    @Bean
    public UserDaoImpl2 dao2(){
        return new UserDaoImpl2("user2", "pass2", "URLTWO");
    }

    @Bean(initMethod = "initialize")
    public LoginService loginService(){
        return new LoginService(dao2());
    }

}
