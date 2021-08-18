package com.learn.di.annotationbased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class LoginService {

    private UserDao dao;

    public LoginService() {
    }

    @Autowired    //required=true default
    public LoginService(@Qualifier("dao2") UserDao dao) {
        this.dao = dao;
    }

    public UserDao getDao() {
        return dao;
    }

    public void setDao(UserDao dao) {
        System.out.println("Setter: Login service");
        this.dao = dao;
    }


    @PostConstruct
    public void initialize(){
        System.out.println("Login Service Initialized");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destroy method executed");
    }


    public void authenticateUser(String userid){
//        UserDaoImpl1 dao = new UserDaoImpl1();
        dao.connectToDb();
        dao.getUserDetails();
    }


}
