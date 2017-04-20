package com.seed.DAO;

import com.seed.Model.User;
import java.util.List;

public interface UserDao {

    void createUser(User newUser);
    List<User> retrieveUsers();
    User retrieveUser(String userID);
    void updateUser(User updatedUser);

}