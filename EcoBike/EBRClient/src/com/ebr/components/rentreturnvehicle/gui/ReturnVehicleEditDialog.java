package com.ebr.components.rentreturnvehicle.gui;

import javax.swing.*;

import com.ebr.bean.Bike;
import com.ebr.bean.Rent;
import com.ebr.bean.Station;
import com.ebr.bean.User;
import com.ebr.components.abstractdata.controller.IDataManageController;
import com.ebr.components.abstractdata.controller.IReturnVehicleManageController;
import com.ebr.components.abstractdata.gui.ADataEditDialog;
import com.ebr.components.abstractdata.gui.AReturnVehicleEditDialog;
import com.ebr.serverapi.RentApi;
import com.ebr.serverapi.StationApi;
import com.ebr.serverapi.UserApi;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class ReturnVehicleEditDialog extends AReturnVehicleEditDialog<Bike> {
	
	private JLabel idField;
	private JLabel nameField;
	private JLabel accountBalanceField;

//	private JComboBox<String> stationNameCb;
	private JTextField stationNameField;

	private User user;
	private Rent rent;
	
//	private StationApi stationApi = new StationApi();
	
	public ReturnVehicleEditDialog(Bike bike, IReturnVehicleManageController<Bike> controller) {
		super(bike, controller);
	}

	@Override
	public void buildControls() {
		Map<String, String> map = new HashMap<>() ;
		map.put("bikeId", t.getId());
		rent = new RentApi().getAllRents(map).get(0);
		map.remove("bikeId");
		map.put("userId", rent.getUserId());
		user = new UserApi().getUser(map).get(0);


		int row = getLastRowIndex();
		JLabel idLabel = new JLabel("UserID");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(idLabel, c);
		idField = new JLabel();
		idField.setText(user.getUserId());
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(idField, c);


		row = getLastRowIndex();
		JLabel nameLabel = new JLabel("UserName");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(nameLabel, c);
		nameField = new JLabel();
		nameField.setText(user.getName());
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(nameField, c);

		row = getLastRowIndex();
		JLabel accountBalanceLabel = new JLabel("Account Balance");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(accountBalanceLabel, c);
		accountBalanceField = new JLabel();
		accountBalanceField.setText(user.getAccountBalance() + "");
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(accountBalanceField, c);

		row = getLastRowIndex();
		JLabel stationNameLabel = new JLabel("Station");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(stationNameLabel, c);
		stationNameField = new JTextField(20);
		stationNameField.setText("");
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(stationNameField, c);
	}

	@Override
	public Bike getNewData() {
		Bike st = new Bike();
		st.setId(t.getId());
		st.setStationId(stationNameField.getText());
		return st;
	}
}
