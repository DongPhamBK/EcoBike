package com.ebr.components.rentreturnvehicle.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import com.ebr.bean.Bike;
import com.ebr.bean.Rent;
import com.ebr.bean.Station;
import com.ebr.bean.User;
import com.ebr.components.abstractdata.controller.ADataPageController;
import com.ebr.components.abstractdata.controller.AReturnVehiclePageController;
import com.ebr.components.abstractdata.controller.IDataManageController;
import com.ebr.components.abstractdata.controller.IReturnVehicleManageController;
import com.ebr.components.abstractdata.gui.ADataListPane;
import com.ebr.components.abstractdata.gui.ADataSinglePane;

import com.ebr.components.abstractdata.gui.AReturnVehicleListPane;
import com.ebr.components.abstractdata.gui.AReturnVehicleSinglePane;
import com.ebr.components.client.controller.UserReturnVehiclePageController;
import com.ebr.serverapi.BikeApi;
import com.ebr.serverapi.RentApi;
import com.ebr.serverapi.StationApi;
import com.ebr.serverapi.UserApi;

@SuppressWarnings("serial")
public class ReturnVehicleListPane extends AReturnVehicleListPane<Bike> {
	
	public 	ReturnVehicleListPane(AReturnVehiclePageController<Bike> controller) {
		this.controller = controller;
	}
	
	@Override
	public void decorateSinglePane(AReturnVehicleSinglePane<Bike> singlePane) {
		JButton button = new JButton("Return Vehicle");
		singlePane.addDataHandlingComponent(button);

		IReturnVehicleManageController<Bike> manageController = new IReturnVehicleManageController<Bike>() {

			@Override
			public void returnVehicle(Bike bike) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("id", bike.getId());
				Bike bikeUpdate = new BikeApi().getBikes(map).get(0);
				map.remove("id");
				map.put("bikeId", bike.getId());
				Rent rent = new RentApi().getAllRents(map).get(0);
				map.remove("bikeId");
				map.put("userId", rent.getUserId());
				User user = new UserApi().getUser(map).get(0);
				map.remove("userId");
				map.put("stationId", bike.getStationId());
				Station station = new StationApi().getStation(map).get(0);

				boolean isNormalBike = false;
				boolean isEbike = false;
				long deposit = 0;
				int time = (int) ((new Date().getTime()-rent.getRentTime().getTime())/60000);
				if(bikeUpdate.getBikeType().equals("BIKE")) {
					isNormalBike = true;
					deposit = 400000;
				} else if(bikeUpdate.getBikeType().equals("EBIKE")) {
					isEbike = true;
					deposit = 700000;
				} else if(bikeUpdate.getBikeType().equals("TWINBIKE")) {
					deposit = 550000;
				}
				long totalCost = getTotalCost(time, isNormalBike);
				user.setAccountBalance(user.getAccountBalance() + deposit);
				if(user.getAccountBalance()<totalCost) {
					JOptionPane.showMessageDialog(null, "Do not enough money !!!");
					return;
				}

				if(isNormalBike) {
					station.setNumberBikes(station.getNumberBikes()+1);
				} else if(isEbike) {
					station.setNumberEBikes(station.getNumberEBikes()+1);
				}else {
					station.setNumberTwinBikes(station.getNumberTwinBikes()+1);
				}
				station.setNumberEmptyDocks(station.getNumberEmptyDocks()+1);
				new StationApi().updateStation(station);

				bikeUpdate.setStationId(station.getStationId());
				bikeUpdate.setStatus("Empty");
				new BikeApi().updateBike(bikeUpdate);

				user.setAccountBalance(user.getAccountBalance()-totalCost);
				new UserApi().updateUser(user);

				new RentApi().deleteRent(rent);

				JOptionPane.showMessageDialog(null, "Return vehicle success !!!");


			}
		};
		 
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ReturnVehicleEditDialog(singlePane.getData(), manageController);
			}
		});	
	}

	public long getTotalCost(int time, boolean isNormalBike) {
		long result = 0;
		if(isNormalBike) {
			if(time<=10) return 0;
			if(time<=30) {
				return 10000;
			} else {
				int temp = (time-30)/15;
				if((time-30)%15 != 0) temp++;
				result = 10000 + temp*3000;
			}
		} else {
			if(time<=10) return 0;
			if(time<=30) {
				return 15000;
			} else {
				int temp = (time-30)/15;
				if((time-30)%15 != 0) temp++;
				result = 15000 + temp*4500;
			}
		}
		return result;
	}
}
