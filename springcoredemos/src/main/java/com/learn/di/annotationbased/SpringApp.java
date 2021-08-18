package com.learn.di.annotationbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("annotationbeans.xml");

        LoginService loginService = context.getBean(LoginService.class);
        loginService.authenticateUser("123");


    }
}
