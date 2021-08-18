package com.learn.di.annotationbased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppAnnotation {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext("com.learn.di.annotationbased");

        LoginService loginService = context.getBean(LoginService.class);
        loginService.authenticateUser("123");


    }
}
