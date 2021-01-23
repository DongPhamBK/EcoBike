package com.ebr.components.rentreturnvehicle.gui;

import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ebr.components.abstractdata.gui.ADataSearchPane;

//ham tim kiem goc cua station
@SuppressWarnings("serial")
public class RentVehicleSearchPane extends ADataSearchPane {
	private JTextField bikeIdField;
	private JTextField bikeTypeField;

	public RentVehicleSearchPane() {
		super();
	}
	
	@Override
	public void buildControls() {
		JLabel bikeIdLabel = new JLabel("Bike Id");
		bikeIdField = new JTextField(15);
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(bikeIdLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(bikeIdField, c);
		
		
		JLabel bikeTypeLabel = new JLabel("Bike Type");
		bikeTypeField = new JTextField(15);
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(bikeTypeLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(bikeTypeField, c);
	}

	@Override
	public Map<String, String> getQueryParams() {
		Map<String, String> res = super.getQueryParams();
		
		if (!bikeIdField.getText().trim().equals("")) {
			res.put("id", bikeIdField.getText().trim());
		}
		if (!bikeTypeField.getText().trim().equals("")) {
			res.put("bikeType", bikeTypeField.getText().trim());
		}
		
		return res;
	}
}
