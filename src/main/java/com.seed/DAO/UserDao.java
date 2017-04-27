package com.seed.DAO;

import com.seed.Model.User;
import java.util.List;
import java.util.Map;

public interface UserDao {

    void createUser(User newUser);
    List<User> retrieveUsers(int managerID);
    User retrieveUser(String userName);
    User retrieveUser(int  userID);
    void updateUser(User updatedUser);
    Map <Integer, Integer> retrieveEmployeeMap();
}