package com.learn.di.collections;

import com.learn.di.xml.LoginService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLoginApp {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beanscollections.xml");
        context.registerShutdownHook();

        UserDao userDao = context.getBean(UserDao.class);
        userDao.connectToDb();
    }

}
