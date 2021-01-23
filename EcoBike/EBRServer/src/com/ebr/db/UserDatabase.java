package com.ebr.db;

import java.util.ArrayList;

import com.ebr.bean.User;

public interface UserDatabase {
    public ArrayList<User> searchUser(User user);

    public User updateUser(User user);
}
