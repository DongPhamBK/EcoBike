package com.ebr.components.client.controller;

import com.ebr.bean.Bike;
import com.ebr.components.abstractdata.controller.ADataPageController;
import com.ebr.components.abstractdata.gui.ADataListPane;
import com.ebr.components.gui.bike.AdminBikeListPane;

public abstract class AdminBikePageController extends ADataPageController<Bike> {
    public AdminBikePageController() {
        super();
    }

    @Override
    public ADataListPane<Bike> createListPane() {
        return new AdminBikeListPane(this);
    }

    public abstract Bike updateBike(Bike bike);

    public abstract Bike deleteBike(Bike bike);
    
    public abstract Bike create(Bike bike);

}