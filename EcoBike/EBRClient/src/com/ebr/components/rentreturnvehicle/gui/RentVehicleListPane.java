package com.ebr.components.rentreturnvehicle.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.ebr.bean.Bike;
import com.ebr.components.abstractdata.controller.ADataPageController;
import com.ebr.components.abstractdata.controller.IDataManageController;
import com.ebr.components.abstractdata.gui.ADataListPane;
import com.ebr.components.abstractdata.gui.ADataSinglePane;
import com.ebr.components.client.controller.UserRentVehiclePageController;

@SuppressWarnings("serial")
public class RentVehicleListPane extends ADataListPane<Bike>{
	
	public RentVehicleListPane(ADataPageController<Bike> controller) {
		this.controller = controller;
	}
	
	@Override
	public void decorateSinglePane(ADataSinglePane<Bike> singlePane) {
		JButton button = new JButton("Rent Vehicle");
		singlePane.addDataHandlingComponent(button);
		
//		IDataManageController<Bike> manageController = new IDataManageController<Bike>() {
//			@Override
//			public void update(Bike t) {
//				if (controller instanceof UserRentVehiclePageController) {
//				Bike newBike = ((UserRentVehiclePageController) controller).updateBike(t);
//					singlePane.updateData(newBike);
//				}
//			}
//
//			@Override
//			public void create(Bike t) {
//			}
//
//			@Override
//			public void read(Bike t) {
//			}
//
//			@Override
//			public void delete(Bike t) {
//				
//			}
//		};
		 
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(singlePane.getData().getBatteryPercentage());
				new RentVehicleEditDialog(singlePane.getData());
			}
		});	
	}
}
