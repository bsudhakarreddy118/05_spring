package com.learn.di.xml;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLoginAppAutowired {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.registerShutdownHook();

        LoginService loginService2 = context.getBean("loginService2", LoginService.class);
        loginService2.authenticateUser("123");



    }

}
