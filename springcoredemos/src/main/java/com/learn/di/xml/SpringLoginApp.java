package com.learn.di.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLoginApp {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.registerShutdownHook();

//        UserDao dao1 = context.getBean("dao1", UserDao.class);
//            dao1.connectToDb();

        LoginService loginService = context.getBean("loginService", LoginService.class);

        loginService.authenticateUser("123");

        LoginService loginServiceTwo = context.getBean("loginService", LoginService.class);
        LoginService loginServiceThree = context.getBean("loginService", LoginService.class);

        System.out.println(loginServiceTwo == loginServiceThree);
        System.out.println(loginServiceTwo.hashCode());
        System.out.println(loginServiceThree.hashCode());

    }

}
