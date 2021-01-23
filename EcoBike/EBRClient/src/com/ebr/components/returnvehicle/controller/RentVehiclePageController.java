package com.ebr.components.returnvehicle.controller;

import java.util.List;
import java.util.Map;

import com.ebr.bean.Station;
import com.ebr.bean.Bike;
import com.ebr.components.client.controller.UserRentVehiclePageController;
import com.ebr.components.rentreturnvehicle.gui.RentVehicleSearchPane;
import com.ebr.components.rentreturnvehicle.gui.RentVehicleSinglePane;
import com.ebr.serverapi.BikeApi;

public class RentVehiclePageController extends UserRentVehiclePageController{
	@Override
	public List<? extends Bike> search(Map<String, String> searchParams) {
		return new BikeApi().getBikes(searchParams);
	}
	
	@Override
	public RentVehicleSinglePane createSinglePane() {
		return new RentVehicleSinglePane();
	}
	
	@Override
	public RentVehicleSearchPane createSearchPane() {
		return new RentVehicleSearchPane();
	}
	
	@Override
	public Bike updateBike(Bike bike) {
		return new BikeApi().updateBike((Bike) bike);
	}
}
