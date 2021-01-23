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

import com.ebr.bean.Station;

public class StationApi {
	
public static final String PATH = "http://localhost:8080/";
	
	private Client client;
	
	public StationApi() {
		client = ClientBuilder.newClient();
	}
	
	public ArrayList<Station> getAllStation() {
		WebTarget webTarget = client.target(PATH).path("stations");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		ArrayList<Station> res = response.readEntity(new GenericType<ArrayList<Station>>(){});
		System.out.println(res);
		return res;
	}

	public ArrayList<Station> getStation(Map<String, String> queryParams) {
		WebTarget webTarget = client.target(PATH).path("stations/get/");
		
		
		if (queryParams != null) {
			for (String key : queryParams.keySet()) {
				String value = queryParams.get(key);
				webTarget = webTarget.queryParam(key, value);
			}
		}
		
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		ArrayList<Station> res = response.readEntity(new GenericType<ArrayList<Station>>() {});
		System.out.println(res);
		return res;
	}
	

	public Station updateStation(Station station) {
		WebTarget webTarget = client.target(PATH).path("stations/update/").path(station.getStationId());
		
		Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(station, MediaType.APPLICATION_JSON));
		Station res = response.readEntity(Station.class);
		return res;
	}
	
	
}
