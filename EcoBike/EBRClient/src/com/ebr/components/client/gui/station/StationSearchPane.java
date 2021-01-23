package com.ebr.components.client.gui.station;

import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ebr.components.abstractdata.gui.ADataSearchPane;

//ham tim kiem goc cua station
@SuppressWarnings("serial")
public class StationSearchPane extends ADataSearchPane {
	private JTextField stationIdField;
	private JTextField stationNameField;
	private JTextField stationAddressField;

	public StationSearchPane() {
		super();
	}
	
	@Override
	public void buildControls() {
		JLabel stationIdLabel = new JLabel("Station Id");
		stationIdField = new JTextField(15);
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(stationIdLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(stationIdField, c);
		
		
		JLabel stationNameLabel = new JLabel("Station Name");
		stationNameField = new JTextField(15);
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(stationNameLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(stationNameField, c);
		

		JLabel stationAddressLabel = new JLabel("Station Address");
		stationAddressField = new JTextField(15);
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(stationAddressLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(stationAddressField, c);
	}

	@Override
	public Map<String, String> getQueryParams() {
		Map<String, String> res = super.getQueryParams();
		
		if (!stationIdField.getText().trim().equals("")) {
			res.put("stationId", stationIdField.getText().trim());
		}
		if (!stationNameField.getText().trim().equals("")) {
			res.put("stationName", stationNameField.getText().trim());
		}
		if (!stationAddressField.getText().trim().equals("")) {
			res.put("stationAddress", stationAddressField.getText().trim());
		}
		
		return res;
	}
}
