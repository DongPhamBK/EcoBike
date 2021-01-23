package com.ebr.components.returnvehicle.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ebr.bean.Bike;
import com.ebr.bean.Station;
import com.ebr.components.client.controller.UserReturnVehiclePageController;
import com.ebr.components.rentreturnvehicle.gui.ReturnVehicleSearchPane;
import com.ebr.components.rentreturnvehicle.gui.ReturnVehicleSinglePane;
import com.ebr.serverapi.BikeApi;
import com.ebr.serverapi.RentApi;
import com.ebr.serverapi.StationApi;

public class ReturnVehiclePageController extends UserReturnVehiclePageController{
	
	private RentApi rentApi = new RentApi();
	private BikeApi bikeApi = new BikeApi();
	
	
	@Override
	public List<? extends Bike> search(Map<String, String> searchParams) {
		ArrayList<Bike> listResult = new ArrayList<Bike>();
		if(searchParams.size()==0) {
			return listResult;
		}
		if(rentApi.getAllRents(searchParams)==null || rentApi.getAllRents(searchParams).size()==0) {
			return listResult;
		}
		String bikeId = rentApi.getAllRents(searchParams).get(0).getBikeId();
		searchParams.remove("userId");
		searchParams.put("id", bikeId);
		
		return bikeApi.getBikes(searchParams);
	}
	
	@Override
	public ReturnVehicleSinglePane createSinglePane() {
		return new ReturnVehicleSinglePane();
	}
	
	@Override
	public ReturnVehicleSearchPane createSearchPane() {
		return new ReturnVehicleSearchPane();
	}
	
	@Override
	public Bike updateBike(Bike bike) {
		return new BikeApi().updateBike((Bike) bike);
	}
}
