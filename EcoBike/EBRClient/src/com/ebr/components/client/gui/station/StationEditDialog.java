package com.ebr.components.client.gui.station;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.ebr.bean.Station;
import com.ebr.components.abstractdata.controller.IDataManageController;
import com.ebr.components.abstractdata.gui.ADataEditDialog;

//nghien cuu
@SuppressWarnings("serial")
public class StationEditDialog extends ADataEditDialog<Station>{
	
	private JTextField idField;
	private JTextField nameField;
	private JTextField addressField;
	private JTextField numberBikesField;
	private JTextField numberEBikesField;
	private JTextField numberTwinBikesField;
	private JTextField numberEmptyDocksField;
	private JTextField distanceField;
	private JTextField timeField;
	
	public StationEditDialog(Station station, IDataManageController<Station> controller) {
		super(station, controller);
	}

	@Override
	public void buildControls() {
		int row = getLastRowIndex();
		JLabel idLabel = new JLabel("Id");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(idLabel, c);
		idField = new JTextField(15);
		idField.setText(t.getStationId());//lay id
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(idField, c);
		
		
		row = getLastRowIndex();
		JLabel nameLabel = new JLabel("Name");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(nameLabel, c);
		nameField = new JTextField(15);
		nameField.setText(t.getStationName());
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(nameField, c);
		
		row = getLastRowIndex();
		JLabel addressLabel = new JLabel("Address");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(addressLabel, c);
		addressField = new JTextField(15);
		addressField.setText(t.getStationAddress() + "");
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(addressField, c);
		
		row = getLastRowIndex();
		JLabel bikesLabel = new JLabel("Bikes");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(bikesLabel, c);
		numberBikesField = new JTextField(15);
		numberBikesField.setText(t.getNumberBikes() + "");
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(numberBikesField, c);
		
		row = getLastRowIndex();
		JLabel eBikesLabel = new JLabel("EBikes");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(eBikesLabel, c);
		numberEBikesField = new JTextField(15);
		numberEBikesField.setText(t.getNumberEBikes() + "");
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(numberEBikesField, c);
		
		row = getLastRowIndex();
		JLabel twinBikesLabel = new JLabel("TwinBikes");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(twinBikesLabel, c);
		numberTwinBikesField = new JTextField(15);
		numberTwinBikesField.setText(t.getNumberTwinBikes() + "");
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(numberTwinBikesField, c);
		
		row = getLastRowIndex();
		JLabel emptyDocksLabel = new JLabel("EmptyDocks");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(emptyDocksLabel, c);
		numberEmptyDocksField = new JTextField(15);
		numberEmptyDocksField.setText(t.getNumberEmptyDocks() + "");
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(numberEmptyDocksField, c);
		
		/*
		row = getLastRowIndex();
		JLabel distanceLabel = new JLabel("Distance");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(distanceLabel, c);
		distanceField = new JTextField(15);
		distanceField.setText(t.getStationDistance() + "");
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(distanceField, c);
		
		row = getLastRowIndex();
		JLabel timeLabel = new JLabel("Time");
		c.gridx = 0;
		c.gridy = row;
		getContentPane().add(timeLabel, c);
		timeField = new JTextField(15);
		timeField.setText(t.getStationTime() + "");
		c.gridx = 1;
		c.gridy = row;
		getContentPane().add(timeField, c);
		*/
	}

	@Override
	public Station getNewData() {
		Station st = new Station();
		st.setStationId(idField.getText());
		st.setStationName(nameField.getText());
		st.setStationAddress(addressField.getText());//lay du lieu nhap vao
		st.setNumberBikes(Integer.parseInt(numberBikesField.getText()));
		st.setNumberEBikes(Integer.parseInt(numberEBikesField.getText()));
		st.setNumberTwinBikes(Integer.parseInt(numberTwinBikesField.getText()));
		st.setNumberEmptyDocks(Integer.parseInt(numberEmptyDocksField.getText()));
		//st.setStationDistance(Integer.parseInt(distanceField.getText()));
		//st.setStationTime(Float.parseFloat(timeField.getText()));
		// admin ko can uan tam distance và time
		return st;
	}
}
