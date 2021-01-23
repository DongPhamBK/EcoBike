package com.ebr.components.station.controller;

import java.util.List;
import java.util.Map;

import com.ebr.bean.Station;
import com.ebr.components.client.controller.StationPageController;
import com.ebr.components.client.gui.station.StationSearchPane;
import com.ebr.components.client.gui.station.StationSinglePane;
import com.ebr.serverapi.StationApi;

public class AdminStationPageController extends StationPageController{
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
	
	@Override
	public Station updateStation(Station station) {
		return new StationApi().updateStation((Station) station);
	}
}
