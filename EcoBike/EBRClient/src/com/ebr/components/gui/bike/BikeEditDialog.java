package com.ebr.components.gui.bike;

import com.ebr.bean.Bike;
import com.ebr.components.abstractdata.controller.IDataManageController;
import com.ebr.components.abstractdata.gui.ADataEditDialog;

import javax.swing.*;

@SuppressWarnings("serial")
public class BikeEditDialog extends ADataEditDialog<Bike> {

    private JTextField idField;
    private JTextField nameField;
    private JTextField bikeTypeField;
    private JTextField weightField;
    private JTextField licensePlateField;
    private JTextField manufacturingDateField;
    private JTextField producerField;
    private JTextField costField;
    private JTextField estimateField;
    private JTextField batteryPercentageField;
    private JTextField loadCyclesField;
    private JTextField statusField;
    private JTextField stationIdField;

    public BikeEditDialog(Bike bike, IDataManageController<Bike> controller) {
        super(bike, controller);
    }

    @Override
    public void buildControls() {
        int row = getLastRowIndex();
        JLabel idLabel = new JLabel("Id");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(idLabel, c);
        idField = new JTextField(15);
        idField.setText(t.getId());
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(idField, c);


        row = getLastRowIndex();
        JLabel nameLabel = new JLabel("Name");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(nameLabel, c);
        nameField = new JTextField(15);
        nameField.setText(t.getName());
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(nameField, c);

        row = getLastRowIndex();
        JLabel bikeTypeLabel = new JLabel("Bike Type");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(bikeTypeLabel, c);
        bikeTypeField = new JTextField(15);
        bikeTypeField.setText(t.getBikeType());
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(bikeTypeField, c);

        row = getLastRowIndex();
        JLabel weightLabel = new JLabel("Weight");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(weightLabel, c);
        weightField = new JTextField(15);
        weightField.setText(t.getWeight() + "");
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(weightField, c);

        row = getLastRowIndex();
        JLabel licensePlateLabel = new JLabel("License Plate");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(licensePlateLabel, c);
        licensePlateField = new JTextField(15);
        licensePlateField.setText(t.getLicensePlate());
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(licensePlateField, c);

        row = getLastRowIndex();
        JLabel manufacturingDateLabel = new JLabel("Manufacturing Date");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(manufacturingDateLabel, c);
        manufacturingDateField = new JTextField(15);
        manufacturingDateField.setText(t.getManufacturingDate() + "");
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(manufacturingDateField, c);

        row = getLastRowIndex();
        JLabel producerLabel = new JLabel("Producer");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(producerLabel, c);
        producerField = new JTextField(15);
        producerField.setText(t.getProducer());
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(producerField, c);

        row = getLastRowIndex();
        JLabel costLabel = new JLabel("Cost");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(costLabel, c);
        costField = new JTextField(15);
        costField.setText(t.getCost() + "");
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(costField, c);

        row = getLastRowIndex();
        JLabel estimateLabel = new JLabel("Estimate");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(estimateLabel, c);
        estimateField = new JTextField(15);
        estimateField.setText(t.getEstimate() + "");
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(estimateField, c);

        row = getLastRowIndex();
        JLabel batteryPercentageLabel = new JLabel("Battery Percentage");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(batteryPercentageLabel, c);
        batteryPercentageField = new JTextField(15);
        batteryPercentageField.setText(t.getBatteryPercentage() + "");
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(batteryPercentageField, c);

        row = getLastRowIndex();
        JLabel loadCyclesLabel = new JLabel("Load Cycles");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(loadCyclesLabel, c);
        loadCyclesField = new JTextField(15);
        loadCyclesField.setText(t.getLoadCycles() + "");
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(loadCyclesField, c);

        row = getLastRowIndex();
        JLabel statusLabel = new JLabel("Status");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(statusLabel, c);
        statusField = new JTextField(15);
        statusField.setText(t.getStatus());
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(statusField, c);

        row = getLastRowIndex();
        JLabel stationIdLabel = new JLabel("StationId");
        c.gridx = 0;
        c.gridy = row;
        getContentPane().add(stationIdLabel, c);
        stationIdField = new JTextField(15);
        stationIdField.setText(t.getStationId());
        c.gridx = 1;
        c.gridy = row;
        getContentPane().add(stationIdField, c);
    }

    @Override
    public Bike getNewData() {
        Bike bike = new Bike();
        bike.setId(idField.getText());
        bike.setName(nameField.getText());
        bike.setBikeType(bikeTypeField.getText());
        bike.setWeight(Double.parseDouble(weightField.getText()));
        bike.setLicensePlate(licensePlateField.getText());
        bike.setManufacturingDate(Long.parseLong(manufacturingDateField.getText()));
        bike.setProducer(producerField.getText());
        bike.setCost(Long.parseLong(costField.getText()));
        bike.setEstimate(Double.parseDouble(estimateField.getText()));
        bike.setBatteryPercentage(Double.parseDouble(batteryPercentageField.getText()));
        bike.setLoadCycles(Integer.parseInt(loadCyclesField.getText()));
        bike.setStatus(statusField.getText());
        bike.setStationId(stationIdField.getText());
        return bike;
    }
}
