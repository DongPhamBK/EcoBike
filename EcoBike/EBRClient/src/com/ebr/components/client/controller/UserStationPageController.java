package com.ebr.components.client.controller;

import com.ebr.bean.Station;
import com.ebr.components.abstractdata.controller.ADataPageController;
import com.ebr.components.abstractdata.gui.ADataListPane;
import com.ebr.components.client.gui.station.UserStationListPane;

public abstract class UserStationPageController extends ADataPageController<Station> {
	public UserStationPageController() {
		super();
	}
	
	@Override
	public ADataListPane<Station> createListPane() {
		return new UserStationListPane(this);
	}
	
	
	
}
