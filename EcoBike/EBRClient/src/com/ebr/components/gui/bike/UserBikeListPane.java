package com.ebr.components.gui.bike;

import com.ebr.bean.Bike;
import com.ebr.components.abstractdata.controller.ADataPageController;
import com.ebr.components.abstractdata.gui.ADataListPane;
import com.ebr.components.abstractdata.gui.ADataSinglePane;

import javax.swing.*;

@SuppressWarnings("serial")
public class UserBikeListPane extends ADataListPane<Bike> {

    public UserBikeListPane(ADataPageController<Bike> controller) {
        this.controller = controller;
    }

    @Override
    public void decorateSinglePane(ADataSinglePane<Bike> singlePane) {
        JButton button = new JButton("Rental");
        singlePane.addDataHandlingComponent(button);

    }}