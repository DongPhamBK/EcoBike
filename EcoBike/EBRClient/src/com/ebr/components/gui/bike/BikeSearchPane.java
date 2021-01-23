package com.ebr.components.gui.bike;

import com.ebr.components.abstractdata.gui.ADataSearchPane;

import javax.swing.*;
import java.util.Map;

//ham tim kiem goc cua station
@SuppressWarnings("serial")
public class BikeSearchPane extends ADataSearchPane {
    private JTextField idField;
    private JTextField nameField;
    private JTextField bikeTypeField;
    private JTextField stationIdField;

    public BikeSearchPane() {
        super();
    }

    @Override
    public void buildControls() {
        JLabel idLabel = new JLabel("Id");
        idField = new JTextField(15);
        int row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        add(idLabel, c);
        c.gridx = 1;
        c.gridy = row;
        add(idField, c);


        JLabel nameLabel = new JLabel("Name");
        nameField = new JTextField(15);
        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        add(nameLabel, c);
        c.gridx = 1;
        c.gridy = row;
        add(nameField, c);


        JLabel bikeTypeLabel = new JLabel("Bike Type");
        bikeTypeField = new JTextField(15);
        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        add(bikeTypeLabel, c);
        c.gridx = 1;
        c.gridy = row;
        add(bikeTypeField, c);

        JLabel stationIdLabel = new JLabel("Station");
        stationIdField = new JTextField(15);
        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        add(stationIdLabel, c);
        c.gridx = 1;
        c.gridy = row;
        add(stationIdField, c);
    }

    @Override
    public Map<String, String> getQueryParams() {
        Map<String, String> res = super.getQueryParams();

        if (!idField.getText().trim().equals("")) {
            res.put("id", idField.getText().trim());
        }
        if (!nameField.getText().trim().equals("")) {
            res.put("name", nameField.getText().trim());
        }
        if (!bikeTypeField.getText().trim().equals("")) {
            res.put("bikeType", bikeTypeField.getText().trim());
        }
        if (!stationIdField.getText().trim().equals("")) {
            res.put("stationId", stationIdField.getText().trim());
        }

        return res;
    }
}
