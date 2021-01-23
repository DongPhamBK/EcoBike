package com.ebr.serverapi;

import com.ebr.bean.Bike;

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

public class BikeApi {

    public static final String PATH = "http://localhost:8080/";

    private Client client;

    public BikeApi() {
        client = ClientBuilder.newClient();
    }


    public ArrayList<Bike> getBikes(Map<String, String> queryParams) {
        WebTarget webTarget = client.target(PATH).path("bikes/");


        if (queryParams != null) {
            for (String key : queryParams.keySet()) {
                String value = queryParams.get(key);
                webTarget = webTarget.queryParam(key, value);
            }
        }

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        ArrayList<Bike> res = response.readEntity(new GenericType<ArrayList<Bike>>() {});
        return res;
    }


    public Bike updateBike(Bike bike) {
        WebTarget webTarget = client.target(PATH).path("bikes/update/").path(bike.getId());

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(bike, MediaType.APPLICATION_JSON));
        Bike res = response.readEntity(Bike.class);
        return res;
    }

    public Bike addBike(Bike bike) {
        WebTarget webTarget = client.target(PATH).path("bikes/addBike/");

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(bike, MediaType.APPLICATION_JSON));
        Bike res = response.readEntity(Bike.class);
        return res;
    }

    public Bike deleteBike(Bike bike) {
        WebTarget webTarget = client.target(PATH).path("bikes/delete/").path(bike.getId());

        Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(bike, MediaType.APPLICATION_JSON));
        Bike res = response.readEntity(Bike.class);
        return res;
    }
}
