package com.learn.di.xml;

public class LoginApp {

    public static void main(String[] args) {
        UserDao dao1 = new UserDaoImpl1("user1", "pass1", "URLOne");
        UserDao dao2 = new UserDaoImpl2("user2", "pass2", "URLTwo");
        LoginService service = new LoginService(dao2);
        service.authenticateUser("123");
    }
}
