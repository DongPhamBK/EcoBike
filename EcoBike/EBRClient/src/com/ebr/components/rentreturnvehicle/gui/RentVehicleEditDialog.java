package com.ebr.components.rentreturnvehicle.gui;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.util.Map;
import java.util.HashMap;
import com.ebr.bean.Bike;
import com.ebr.bean.User;
import com.ebr.components.abstractdata.controller.IDataManageController;
import com.ebr.components.abstractdata.gui.ADataRentDialog;
import com.ebr.serverapi.*;
@SuppressWarnings("serial")
public class RentVehicleEditDialog extends ADataRentDialog<Bike>{
	
	private JTextField idCardField;
	
	public RentVehicleEditDialog(Bike bike) {
		super(bike);
	}

	@Override
	public void buildControls() {
		JLabel stationIdLabel = new JLabel("Card Id");
		idCardField = new JTextField(20);
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(stationIdLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(idCardField, c);
	}

	@Override
	public User getNewData() {
		System.out.println(idCardField.getText());
		String st = idCardField.getText();
		System.out.println(st);
		Map<String,String> idCard = new HashMap<String,String>();
		idCard.put("idCard",st);
		User user = new UserApi().getUser(idCard).get(0);
		return user;
	}
}
