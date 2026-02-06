package com.trillio.dao;

import com.trillio.DataStore;
import com.trillio.entities.User;

public class UserDao {
    public User[] getUsers(){
        return DataStore.getUsers();
    }
}
