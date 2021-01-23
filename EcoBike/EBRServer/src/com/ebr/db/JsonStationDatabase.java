package com.ebr.db;

import java.util.ArrayList;


import com.ebr.bean.Station;
import com.ebr.db.seed.Seed;

public class JsonStationDatabase implements StationDatabase{
	private static StationDatabase singleton = new JsonStationDatabase();
	
	
	private ArrayList<Station> stations = Seed.singleton().getStations();
	private JsonStationDatabase() {
	}
	
	public static StationDatabase singleton() {
		return singleton;
	}

	//day là doan code trien khai cho he thong
	@Override
	public ArrayList<Station> searchStation(Station st) {
		ArrayList<Station> res = new ArrayList<Station>();
		for (Station b: stations) {
			if (b.match(st)) {
				res.add(b);
			}
		}
		return res;
	}

	@Override
	public Station addStation(Station st) {
		for (Station m: stations) {
			if (m.equals(st)) {
				return null;
			}
		}
		
		stations.add(st);
		return st;
	}
	
	@Override
	public Station updateStation(Station st) {
		for (Station m: stations) {
			if (m.equals(st)) {
				stations.remove(m);
				stations.add(st);
				return st;
			}
		}
		return null;
	}
}
