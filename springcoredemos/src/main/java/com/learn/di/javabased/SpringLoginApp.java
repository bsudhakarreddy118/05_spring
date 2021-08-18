package com.learn.di.javabased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringLoginApp {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        LoginService loginService = context.getBean(LoginService.class);
        loginService.authenticateUser("abcd");


    }
}
