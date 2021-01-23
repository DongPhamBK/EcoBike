package com.ebr.components.client.controller;

import com.ebr.bean.Station;
import com.ebr.components.abstractdata.controller.ADataPageController;
import com.ebr.components.abstractdata.gui.ADataListPane;
import com.ebr.components.client.gui.station.AdminStationListPane;

//tuong duong admin media page controller
public abstract class StationPageController extends ADataPageController<Station> {
	public StationPageController() {
		super();
	}
	
	@Override
	public ADataListPane<Station> createListPane() {
		return new AdminStationListPane(this);
	}
	
	public abstract Station updateStation(Station station);
	//khong co updateStation, vi vay nen chuong trinh bi loi !
	
}
