package com.ebr.components.gui.bike;

import com.ebr.bean.Bike;
import com.ebr.components.abstractdata.gui.ADataSinglePane;

import javax.swing.*;


@SuppressWarnings("serial")
public class BikeSinglePane extends ADataSinglePane<Bike> {
    private JLabel labelId;
    private JLabel labelName;
    private JLabel labelBikeType;
    private JLabel labelWeight;
    private JLabel labelLicensePlate;
    private JLabel labelManufacturingDate;
    private JLabel labelProducer;
    private JLabel labelCost;
    private JLabel labelEstimate;
    private JLabel labelBatteryPercentage;
    private JLabel labelLoadCycles;
    private JLabel labelStatus;
    private JLabel labelStationId;

    public BikeSinglePane() {
        super();
    }


    public BikeSinglePane(Bike bike) {
        this();
        this.t = bike;
        displayData();
    }

    @Override
    public void buildControls() {
        super.buildControls();

        int row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelId = new JLabel();
        add(labelId, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelName = new JLabel();
        add(labelName, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelBikeType = new JLabel();
        add(labelBikeType, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelWeight = new JLabel();
        add(labelWeight, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelLicensePlate = new JLabel();
        add(labelLicensePlate, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelManufacturingDate = new JLabel();
        add(labelManufacturingDate, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelProducer = new JLabel();
        add(labelProducer, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelCost = new JLabel();
        add(labelCost, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelEstimate = new JLabel();
        add(labelEstimate, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelBatteryPercentage = new JLabel();
        add(labelBatteryPercentage, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelLoadCycles = new JLabel();
        add(labelLoadCycles, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelStatus = new JLabel();
        add(labelStatus, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelStationId = new JLabel();
        add(labelStationId, c);
    }


    @Override
    public void displayData() {
        labelId.setText("Id: " + t.getId());
        labelName.setText("Name: " + t.getName());
        labelBikeType.setText("Bike Type: " + t.getBikeType());
        labelWeight.setText("Weight: "+ t.getWeight());
        labelLicensePlate.setText("License Plate: "+ t.getLicensePlate());
        labelManufacturingDate.setText("Manufacturing Date: "+ t.getManufacturingDate());
        labelProducer.setText("Producer: "+ t.getProducer());
        labelCost.setText("Cost: " + t.getCost());
        labelEstimate.setText("Estimate: " + t.getEstimate());
        labelBatteryPercentage.setText("Battery Percentage: " + t.getBatteryPercentage());
        labelLoadCycles.setText("Load Cycles: " + t.getLoadCycles());
        labelStatus.setText("Status: " + t.getStatus());
        labelStationId.setText("Station Id: " + t.getStationId());
    }
}