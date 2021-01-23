package com.ebr.serverapi;

import com.ebr.bean.User;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class UserApi {

    public static final String PATH = "http://localhost:8080/";

    private Client client;

    public UserApi() {
        client = ClientBuilder.newClient();
    }


    public ArrayList<User> getUser(Map<String, String> queryParams) {
        WebTarget webTarget = client.target(PATH).path("users/get");


        if (queryParams != null) {
            for (String key : queryParams.keySet()) {
                String value = queryParams.get(key);
                webTarget = webTarget.queryParam(key, value);
            }
        }

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        ArrayList<User> res = response.readEntity(new GenericType<ArrayList<User>>() {});
        return res;
    }


    public User updateUser(User user) {
        WebTarget webTarget = client.target(PATH).path("users/update/").path(user.getUserId());

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(user, MediaType.APPLICATION_JSON));
        User res = response.readEntity(User.class);
        return res;
    }
}
