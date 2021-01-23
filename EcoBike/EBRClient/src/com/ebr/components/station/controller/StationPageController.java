package com.ebr.components.station.controller;
//user
import java.util.List;
import java.util.Map;

import com.ebr.bean.Station;
import com.ebr.components.client.controller.UserStationPageController;
import com.ebr.components.client.gui.station.StationSearchPane;
import com.ebr.components.client.gui.station.StationSinglePane;
import com.ebr.serverapi.StationApi;

public class StationPageController extends UserStationPageController{
	@Override
	public List<? extends Station> search(Map<String, String> searchParams) {
		return new StationApi().getStation(searchParams);
	}
	
	@Override
	public StationSinglePane createSinglePane() {
		return new StationSinglePane();
	}
	
	@Override
	public StationSearchPane createSearchPane() {
		return new StationSearchPane();
	}
	
	
}
