package com.trillio.managers;

import com.trillio.dao.UserDao;
import com.trillio.entities.User;

public class UserManager {
    private static UserManager instance = new UserManager();
    private static UserDao dao = new UserDao();
    private UserManager(){}

    public static UserManager getInstance(){
     return instance;
    }

    public User createUser(long id, String email, String password, String firstname, String lastName, int gender, String userType){
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstname);
        user.setLastName(lastName);
        user.setGender(gender);
        user.setUserType(userType);

        return user;
    }

    public User[] getUser(){
        return dao.getUsers();
    }


}
