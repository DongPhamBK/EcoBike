package com.ebr.components.bike.controller;

import com.ebr.bean.Bike;
import com.ebr.bean.Rent;
import com.ebr.components.client.controller.AdminBikePageController;
import com.ebr.components.gui.bike.BikeSearchPane;
import com.ebr.components.gui.bike.BikeSinglePane;
import com.ebr.serverapi.BikeApi;
import com.ebr.serverapi.RentApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class RentalManagerPageController extends AdminBikePageController {

	private BikeApi bikeApi = new BikeApi();
    @Override
    public List<? extends Bike> search(Map<String, String> searchParams) {
    	ArrayList<Bike> listResult = new BikeApi().getBikes(searchParams);
    	for(int i=0 ; i<listResult.size() ; i++) {
    		if(!listResult.get(i).getStatus().equals("Rented")) listResult.remove(i);
    	}
        return listResult;
    }

    @Override
    public BikeSinglePane createSinglePane() {
        return new BikeSinglePane();
    }

    @Override
    public BikeSearchPane createSearchPane() {
        return new BikeSearchPane();
    }

    @Override
    public Bike updateBike(Bike bike) {
        return new BikeApi().updateBike((Bike) bike);
    }

    @Override
    public Bike deleteBike(Bike bike) {
        return new BikeApi().deleteBike((Bike) bike);
    }

    @Override
    public Bike create(Bike bike) {
    	return new BikeApi().addBike((Bike) bike);
    }
}
