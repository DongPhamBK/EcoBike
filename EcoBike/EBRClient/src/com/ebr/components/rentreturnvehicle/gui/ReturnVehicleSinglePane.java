package com.ebr.components.rentreturnvehicle.gui;

import javax.swing.JLabel;

import com.ebr.bean.Bike;
import com.ebr.bean.Rent;
import com.ebr.bean.Station;
import com.ebr.components.abstractdata.gui.ADataSinglePane;
import com.ebr.components.abstractdata.gui.AReturnVehicleSinglePane;
import com.ebr.serverapi.RentApi;
import com.ebr.serverapi.StationApi;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//ban mau co ban cua station
@SuppressWarnings("serial")
public class ReturnVehicleSinglePane extends AReturnVehicleSinglePane<Bike> {
	private JLabel labelBikeId;
	private JLabel labelBikeName;
	private JLabel labelBikeType;
	private JLabel labelLicensePlate;
	private JLabel labelCost;
	private JLabel labelEstimate;
	private JLabel labelBatteryPercentage;
	private JLabel labelLoadCycles;
	private JLabel labelStation;
	private JLabel labelRentTime;

	private Station station;
	private Rent rent;
	
	public ReturnVehicleSinglePane() {
		super();
	}
		
	
	public ReturnVehicleSinglePane(Bike bike) {
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
		labelLicensePlate = new JLabel();
		add(labelLicensePlate, c);

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
		labelStation = new JLabel();
		add(labelStation, c);

		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelRentTime = new JLabel();
		add(labelRentTime, c);

	}
	
	
	@Override
	public void displayData() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("bikeId", t.getId());
		Rent rent;
		if(new RentApi().getAllRents(map) != null && new RentApi().getAllRents(map).size()>0) {
			System.out.println(111111111);
			System.out.println(new RentApi().getAllRents(map).size() + "2222222");
			 rent = new RentApi().getAllRents(map).get(0);
		} else {
			rent = new Rent();
		}

		if(rent.getRentTime()==null) rent.setRentTime(new Date());
		map.remove("bikeId");
		map.put("stationId", t.getStationId());
		Station station = new StationApi().getStation(map).get(0);

		labelBikeId.setText("Bike Id: " + t.getId());
		labelBikeName.setText("Bike Name: " + t.getName());
		labelBikeType.setText("Bike Type: " + t.getBikeType());
		labelLicensePlate.setText("Bike License Plate: " + t.getLicensePlate());
		labelCost.setText("Cost: " + t.getCost() + "");
		labelEstimate.setText("Bike Estimate: " + t.getEstimate());
		labelBatteryPercentage.setText("Bike Battery Percentage: " + t.getBatteryPercentage());
		labelLoadCycles.setText("Bike Load Cycles: " + t.getLoadCycles());
		labelStation.setText("Station: " + station.getStationName());
		labelRentTime.setText("Rent time: " + rent.getRentTime());
	}
}
