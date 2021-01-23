package com.ebr.components.bike.controller;

import com.ebr.bean.Bike;
import com.ebr.components.client.controller.AdminBikePageController;
import com.ebr.components.gui.bike.BikeSearchPane;
import com.ebr.components.gui.bike.BikeSinglePane;
import com.ebr.serverapi.BikeApi;
import java.util.List;
import java.util.Map;



public class BikeManagerPageController extends AdminBikePageController {
    @Override
    public List<? extends Bike> search(Map<String, String> searchParams) {
        return new BikeApi().getBikes(searchParams);
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
