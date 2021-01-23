package com.ebr.serverapi;

import com.ebr.bean.Rent;

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

public class RentApi {

    public static final String PATH = "http://localhost:8080/";

    private Client client;

    public RentApi() {
        client = ClientBuilder.newClient();
    }

    public ArrayList<Rent> getAllRents(Map<String, String> queryParams) {
        WebTarget webTarget = client.target(PATH).path("rents/");


        if (queryParams != null) {
            for (String key : queryParams.keySet()) {
                String value = queryParams.get(key);
                webTarget = webTarget.queryParam(key, value);
            }
        }

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        ArrayList<Rent> res = response.readEntity(new GenericType<ArrayList<Rent>>() {});
        return res;
    }
    
   

    public Rent updateRent(Rent rent) {
        WebTarget webTarget = client.target(PATH).path("rents/update/").path(rent.getRentId());

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(rent, MediaType.APPLICATION_JSON));
        Rent res = response.readEntity(Rent.class);
        return res;
    }

    public Rent addRent(Rent rent) {
        WebTarget webTarget = client.target(PATH).path("rents/addRent/");

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(rent, MediaType.APPLICATION_JSON));
        Rent res = response.readEntity(Rent.class);
        return res;
    }

    public Rent deleteRent(Rent rent) {
        WebTarget webTarget = client.target(PATH).path("rents/delete/").path(rent.getRentId());

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(rent, MediaType.APPLICATION_JSON));
        Rent res = response.readEntity(Rent.class);
        return res;
    }
}
