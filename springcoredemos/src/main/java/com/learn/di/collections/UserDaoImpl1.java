package com.learn.di.collections;

import java.util.HashMap;
import java.util.Properties;

public class UserDaoImpl1 implements UserDao {

    private Properties dbProperties;

    public UserDaoImpl1() {
    }

    public UserDaoImpl1(Properties dbProperties) {
        this.dbProperties = dbProperties;
    }

    public Properties getDbProperties() {
        return dbProperties;
    }

    public void setDbProperties(Properties dbProperties) {
        this.dbProperties = dbProperties;
    }

    @Override
    public void connectToDb() {
        System.out.println("Connexting to DB using Spring DAO with user name " + dbProperties.getProperty("username")
                + " db url " + dbProperties.getProperty("dburl"));
    }

    @Override
    public void getUserDetails() {

    }


    //  HashTable -- > Dictionary -- > Properties ( string, string)

}
