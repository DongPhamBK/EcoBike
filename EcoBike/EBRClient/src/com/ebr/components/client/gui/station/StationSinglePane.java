package com.ebr.components.client.gui.station;

import javax.swing.JLabel;

import com.ebr.bean.Station;
import com.ebr.components.abstractdata.gui.ADataSinglePane;
//ban mau co ban cua station
@SuppressWarnings("serial")
public class StationSinglePane extends ADataSinglePane<Station>{
	private JLabel labelStationId;
	private JLabel labelStationName;
	private JLabel labelStationAddress;
	private JLabel labelNumberBikes;
	private JLabel labelNumberEBikes;
	private JLabel labelNumberTwinBikes;
	private JLabel labelNumberEmptyDocks;
	private JLabel labelStationDistance;
	private JLabel labelStationTime;
	
	public StationSinglePane() {
		super();
	}
		
	
	public StationSinglePane(Station station) {
		this();
		this.t = station;
		
		displayData();
	}

	@Override
	public void buildControls() {
		super.buildControls();
		
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelStationId = new JLabel();
		add(labelStationId, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelStationName = new JLabel();
		add(labelStationName, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelStationAddress = new JLabel();
		add(labelStationAddress, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelNumberBikes = new JLabel();
		add(labelNumberBikes, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelNumberEBikes = new JLabel();
		add(labelNumberEBikes, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelNumberTwinBikes = new JLabel();
		add(labelNumberTwinBikes, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelNumberEmptyDocks = new JLabel();
		add(labelNumberEmptyDocks, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelStationDistance = new JLabel();
		add(labelStationDistance, c);
		
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		labelStationTime = new JLabel();
		add(labelStationTime, c);
	}
	
	
	@Override
	public void displayData() {
		labelStationId.setText("Station Id: " + t.getStationId());
		labelStationName.setText("Station Name: " + t.getStationName());
		labelStationAddress.setText("Station Address: " + t.getStationAddress());
		labelNumberBikes.setText("Number of Bikes: "+ t.getNumberBikes());
		labelNumberEBikes.setText("Number of EBikes: "+ t.getNumberEBikes());
		labelNumberTwinBikes.setText("Number of TwinBikes: "+ t.getNumberTwinBikes());
		labelNumberEmptyDocks.setText("Number of Empty Docks: "+ t.getNumberEmptyDocks());
	}
}
