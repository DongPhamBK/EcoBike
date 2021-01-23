package com.ebr.service;

import com.ebr.bean.User;
import com.ebr.db.UserDatabase;
import com.ebr.db.JsonUserDatabase;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/users")
public class UserService {

    private UserDatabase userDatabase;

    public UserService() {
        userDatabase = JsonUserDatabase.singleton();
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getUser(@QueryParam("userId") String userId, @QueryParam("name") String name,
                                   @QueryParam("idCard") String idCard, @QueryParam("accountBalance") long accountBalance) {
        User user = new User(userId, name, idCard,accountBalance);
        ArrayList<User> res = userDatabase.searchUser(user);
        return res;

    }

    @POST
    @Path("/update/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public User updateUser(@PathParam("userId") String userId, User user) {
        return userDatabase.updateUser(user);
    }
}
