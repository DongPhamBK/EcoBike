package com.ebr.db;

import com.ebr.bean.User;
import com.ebr.db.seed.Seed;

import java.util.ArrayList;


public class JsonUserDatabase implements UserDatabase{

    private static UserDatabase singleton = new JsonUserDatabase();

    private ArrayList<User> users = Seed.singleton().getUsers();

    private JsonUserDatabase() {}

    public static UserDatabase singleton() {
        return singleton;
    }

    @Override
    public ArrayList<User> searchUser(User user){
        ArrayList<User> res = new ArrayList<>();
        for (User b: users) {
            if (b.match(user)) {
                res.add(b);
            }
        }
        return res;
    };
    @Override
    public User updateUser(User user) {
        for (User m: users) {
            if (m.equals(user)) {
                users.remove(m);
                users.add(user);
                return user;
            }
        }
        return null;
    };
}
