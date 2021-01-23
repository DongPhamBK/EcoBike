package com.ebr.db.seed;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.ebr.bean.Bike;
import com.ebr.bean.Rent;
import com.ebr.bean.Station;
import com.ebr.bean.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

// thao tac json
public class Seed {
	// private ArrayList<Media> medias;
	private ArrayList<Station> stations;
	private ArrayList<Bike> bikes;
	private ArrayList<Rent> rents;
	private ArrayList<User> users;

	private static Seed singleton = new Seed();

	private Seed() {
		start();
	}

	public static Seed singleton() {
		return singleton;
	}

	private void start() {

		stations = new ArrayList<Station>();
		stations.addAll(generateStationFromFile(new File(getClass().getResource("./stations.json").getPath()).toString()));

		bikes = new ArrayList<Bike>();
		bikes.addAll(generateBikeFromFile(new File(getClass().getResource("./bikes.json").getPath()).toString()));

		rents = new ArrayList<Rent>();
		rents.addAll(generateRentFromFile(new File(getClass().getResource("./rents.json").getPath()).toString()));

		users = new ArrayList<User>();
		users.addAll(generateUserFromFile(new File(getClass().getResource("./user.json").getPath()).toString()));
	}

	private ArrayList<? extends Station> generateStationFromFile(String filePath) {
		ArrayList<? extends Station> res = new ArrayList<Station>();
		ObjectMapper mapper = new ObjectMapper();

		String json = FileReader.read(filePath);
		try {
			mapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
			res = mapper.readValue(json, new TypeReference<ArrayList<Station>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Invalid JSON input data from " + filePath);
		}

		return res;
	}

	private ArrayList<? extends Bike> generateBikeFromFile(String filePath) {
		ArrayList<? extends Bike> res = new ArrayList<Bike>();
		ObjectMapper mapper = new ObjectMapper();

		String json = FileReader.read(filePath);
		try {
			mapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
			res = mapper.readValue(json, new TypeReference<ArrayList<Bike>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Invalid JSON input data from " + filePath);
		}

		return res;
	}

	private ArrayList<? extends Rent> generateRentFromFile(String filePath) {
		ArrayList<? extends Rent> res = new ArrayList<Rent>();
		ObjectMapper mapper = new ObjectMapper();

		String json = FileReader.read(filePath);
		try {
			mapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
			res = mapper.readValue(json, new TypeReference<ArrayList<Rent>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Invalid JSON input data from " + filePath);
		}

		return res;
	}

	private ArrayList<? extends User> generateUserFromFile(String filePath) {
		ArrayList<? extends User> res = new ArrayList<User>();
		ObjectMapper mapper = new ObjectMapper();

		String json = FileReader.read(filePath);
		try {
			mapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
			res = mapper.readValue(json, new TypeReference<ArrayList<User>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Invalid JSON input data from " + filePath);
		}

		return res;
	}

	public ArrayList<Station> getStations() {
		return stations;
	}

	public ArrayList<Bike> getBikes() {
		return bikes;
	}

	public ArrayList<Rent> getRents() {
		return rents;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public static void main(String[] args) {
		Seed seed = new Seed();
		seed.start();
		System.out.println(seed.getStations());
	}
}
