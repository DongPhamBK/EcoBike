package com.ebr.serverapi;

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

import com.ebr.bean.RentalData;


public class RentalApi {
	public static final String PATH = "http://localhost:8080/";
	
	private Client client;
	
	public RentalApi() {
		client = ClientBuilder.newClient();
	}
	
	public ArrayList<RentalData> getBike(Map<String, String> queryParams) {
		WebTarget webTarget = client.target(PATH).path("bike");
		
		if (queryParams != null) {
			for (String key : queryParams.keySet()) {
				String value = queryParams.get(key);
				webTarget = webTarget.queryParam(key, value);
			}
		}
		
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		ArrayList<RentalData> res = response.readEntity(new GenericType<ArrayList<RentalData>>() {});
		System.out.println(res);
		return res;
	}
	
	public RentalData updateBike(RentalData bike, String cardId) {
		WebTarget webTarget = client.target(PATH).path("bike").path(bike.getId()).path(cardId);
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(bike, MediaType.APPLICATION_JSON));
		return null;
	}
	
}
