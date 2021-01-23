package com.ebr.components.client.controller;

import com.ebr.bean.Bike;
import com.ebr.components.abstractdata.controller.ADataPageController;
import com.ebr.components.abstractdata.gui.ADataListPane;
import com.ebr.components.gui.bike.UserBikeListPane;

public abstract class UserBikePageController extends ADataPageController<Bike> {
    public UserBikePageController() {
        super();
    }

    @Override
    public ADataListPane<Bike> createListPane() {
        return new UserBikeListPane(this);
    }
}