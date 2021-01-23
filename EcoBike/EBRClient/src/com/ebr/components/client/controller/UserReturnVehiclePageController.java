package com.ebr.components.client.controller;

import com.ebr.bean.Bike;
import com.ebr.bean.Station;
import com.ebr.components.abstractdata.controller.ADataPageController;
import com.ebr.components.abstractdata.controller.AReturnVehiclePageController;
import com.ebr.components.abstractdata.gui.ADataListPane;
import com.ebr.components.abstractdata.gui.AReturnVehicleListPane;
import com.ebr.components.rentreturnvehicle.gui.ReturnVehicleListPane;

public abstract class UserReturnVehiclePageController extends AReturnVehiclePageController<Bike> {
	public UserReturnVehiclePageController() {
		super();
	}
	
	@Override
	public AReturnVehicleListPane<Bike> createListPane() {
		return new ReturnVehicleListPane(this);
	}
	
	public abstract Bike updateBike(Bike bike);
	
}
