package com.ebr.serverapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ebr.bean.Card;


public class CardViewApi {
	
	public static final String PATH = "http://localhost:8080/";
	
	private Client client;
	
	public CardViewApi() {
		client = ClientBuilder.newClient();
	}
	
	public ArrayList<Card> getAll() {
		WebTarget webTarget = client.target(PATH).path("card/all");
		
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		ArrayList<Card> res = response.readEntity(new GenericType<ArrayList<Card>>() {});
		System.out.println(res);
		return res;
	}

	public ArrayList<Card> getCards(Map<String, String> queryParams) {
		WebTarget webTarget = client.target(PATH).path("cards");
		
		if (queryParams != null) {
			for (String key : queryParams.keySet()) {
				String value = queryParams.get(key);
				webTarget = webTarget.queryParam(key, value);
			}
		}
		
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		ArrayList<Card> res = response.readEntity(new GenericType<ArrayList<Card>>() {});
		System.out.println(res);
		return res;
	}

	public Card pay(String cardId, int money) {
		WebTarget webTarget = client.target(PATH).path("cards").path("reduceMoney").path(cardId);
		
		webTarget = webTarget.queryParam("money", money);
		
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		Card res = response.readEntity(new GenericType<Card>() {});
		System.out.println(res);
		return res;
	}
	
}