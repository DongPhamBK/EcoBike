package com.ebr.components.rentreturnvehicle.gui;

import javax.swing.JLabel;

import com.ebr.bean.Bike;
import com.ebr.components.abstractdata.gui.ADataSinglePane;
//ban mau co ban cua station
@SuppressWarnings("serial")
public class RentVehicleSinglePane extends ADataSinglePane<Bike>{
	private JLabel labelBikeId;
	private JLabel labelBikeName;
	private JLabel labelBikeType;
	private JLabel labelBikeWeight;
	private JLabel labelLicensePlate;
	private JLabel labelManufacturingDate;
	private JLabel labelProducer;
	private JLabel labelCost;
	private JLabel labelBattery;
	private JLabel labelEstimate;
	private JLabel labelLoadCycles;
	private JLabel labelStaionId;
	private JLabel labelStatus;
	public RentVehicleSinglePane() {
		super();
	}
		
	
	public RentVehicleSinglePane(Bike bike) {
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
		labelBikeId = new JLabel();
		add(labelBikeId, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelBikeName = new JLabel();
		add(labelBikeName, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelBikeType = new JLabel();
		add(labelBikeType, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelBikeWeight = new JLabel();
		add(labelBikeWeight, c);
		
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
		labelBattery = new JLabel();
		add(labelBattery, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelEstimate = new JLabel();
		add(labelEstimate, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelLoadCycles = new JLabel();
		add(labelLoadCycles, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelStaionId = new JLabel();
		add(labelStaionId, c);
	}
	
	
	@Override
	public void displayData() {
		labelBikeId.setText("Bike Id: " + t.getId());
		labelBikeName.setText("Bike Name: " + t.getName());
		labelBikeType.setText("Bike Type: " + t.getBikeType());
		labelBikeWeight.setText("Bike Weight: "+ t.getWeight());
		labelBattery.setText("Bike Battery: " + t.getBatteryPercentage());
		labelLicensePlate.setText("License Plate: "+ t.getLicensePlate());
		labelManufacturingDate.setText("Manufacturing Date: "+ t.getManufacturingDate());
		labelProducer.setText("Producer: "+ t.getProducer());
		labelCost.setText("Cost: "+ t.getCost());
		labelEstimate.setText("Estimate: "+ t.getEstimate());
		labelLoadCycles.setText("Load Cycles: "+ t.getLoadCycles());
		labelStaionId.setText("Station Id: "+ t.getStationId());

	}
}
