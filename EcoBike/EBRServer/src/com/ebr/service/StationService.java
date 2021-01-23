package com.ebr.service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import com.ebr.bean.Station;
import com.ebr.db.StationDatabase;
import com.ebr.db.JsonStationDatabase;

//ok, ta se doc cac thuoc tinh cua station
@Path("/stations")
public class StationService {
	private StationDatabase stationDatabase;
	public StationService() {
		stationDatabase = JsonStationDatabase.singleton();
	}

	 
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Station> getStation(@QueryParam("stationId") String stationId, @QueryParam("stationName") String stationName,
			@QueryParam("stationAddress") String stationAddress, @QueryParam("numberBikes") int numberBikes,
			@QueryParam("numberEBikes") int numberEBikes,
			@QueryParam("numberTwinBikes") int numberTwinBikes,
			@QueryParam("numberEmptyDocks") int numberEmptyDocks,
			@QueryParam("stationDistance") int stationDistance,
			@QueryParam("stationTime") float stationTime) {
		Station station = new Station(stationId, stationName, stationAddress);
		station.setNumberBikes(numberBikes);
		station.setNumberEBikes(numberEBikes);
		station.setNumberTwinBikes(numberTwinBikes);
		station.setNumberEmptyDocks(numberEmptyDocks);
		ArrayList<Station> res = stationDatabase.searchStation(station);
		return res;
		
	}

	@POST
	@Path("/update/{sationId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Station updateStation(@PathParam("sationId") String stationId, Station station) {
		return stationDatabase.updateStation(station);
	}
}
