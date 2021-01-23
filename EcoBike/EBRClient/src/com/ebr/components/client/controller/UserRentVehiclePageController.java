package com.ebr.components.client.controller;

import com.ebr.bean.Bike;
import com.ebr.components.abstractdata.controller.ADataPageController;
import com.ebr.components.abstractdata.gui.ADataListPane;
import com.ebr.components.rentreturnvehicle.gui.RentVehicleListPane;

public abstract class UserRentVehiclePageController extends ADataPageController<Bike> {
	public UserRentVehiclePageController() {
		super();
	}
	
	@Override
	public ADataListPane<Bike> createListPane() {
		return new RentVehicleListPane(this);
	}
	
	public abstract Bike updateBike(Bike bike);
	
}
