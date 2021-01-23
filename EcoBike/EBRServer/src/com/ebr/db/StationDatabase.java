package com.ebr.db;

import java.util.ArrayList;


import com.ebr.bean.Station;

public interface StationDatabase {
	// them moi interface cho admin
	public ArrayList<Station> searchStation(Station station);

	public Station updateStation(Station station);

	public Station addStation(Station station);
}
