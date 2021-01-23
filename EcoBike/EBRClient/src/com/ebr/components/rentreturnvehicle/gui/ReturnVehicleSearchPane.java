package com.ebr.components.rentreturnvehicle.gui;

import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ebr.components.abstractdata.gui.ADataSearchPane;
import com.ebr.components.abstractdata.gui.AReturnVehicleSearchPane;

//ham tim kiem goc cua station
@SuppressWarnings("serial")
public class ReturnVehicleSearchPane extends AReturnVehicleSearchPane {
	private JTextField userIdField;

	public ReturnVehicleSearchPane() {
		super();
	}
	
	@Override
	public void buildControls() {
		JLabel userIdLabel = new JLabel("UserId :    ");
		userIdField = new JTextField(15);
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(userIdLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(userIdField, c);
	}

	@Override
	public Map<String, String> getQueryParams() {
		Map<String, String> res = super.getQueryParams();
		
		if (!userIdField.getText().trim().equals("")) {
			res.put("userId", userIdField.getText().trim());
		}
		
		return res;
	}
}
