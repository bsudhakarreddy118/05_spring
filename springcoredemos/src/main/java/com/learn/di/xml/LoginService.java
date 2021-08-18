package com.learn.di.xml;

import org.springframework.beans.factory.InitializingBean;

public class LoginService {

    private UserDao dao;

    public LoginService() {
    }

    public LoginService(UserDao dao) {
        this.dao = dao;
    }

    public void setDao(UserDao dao) {
        System.out.println("Setter: Login service");
        this.dao = dao;
    }

    public void initialize(){
        System.out.println("Login Service Initialized");
    }

    public void destroy(){
        System.out.println("Destroy method executed");
    }


    public void authenticateUser(String userid){
//        UserDaoImpl1 dao = new UserDaoImpl1();
        dao.connectToDb();
        dao.getUserDetails();
    }


}
