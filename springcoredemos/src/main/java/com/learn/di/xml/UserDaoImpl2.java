package com.learn.di.xml;

public class UserDaoImpl2 implements  UserDao{

    private String username;
    private String password;
    private String dbUrl;

    public UserDaoImpl2() {
        System.out.println("Default Constructor : UserDaoImpl2");
    }

    public UserDaoImpl2(String username, String password, String dbUrl) {
        System.out.println("Parameterized Constructor : UserDaoImpl2");
        this.username = username;
        this.password = password;
        this.dbUrl = dbUrl;
    }

    public void connectToDb(){
        System.out.println("Connected to DB using Spring Data " + username + " url : " + dbUrl);
    }

    public void getUserDetails(){
        System.out.println("Fetched user creds from DB");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public void setDbUrl(String dbUrl) {
        System.out.println("Setter Executed : UserDaoImpl1");
        this.dbUrl = dbUrl;
    }
}
