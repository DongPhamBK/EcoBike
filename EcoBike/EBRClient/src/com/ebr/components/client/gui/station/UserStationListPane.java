package com.ebr.components.client.gui.station;

import javax.swing.*;

import com.ebr.bean.Bike;
import com.ebr.bean.Station;
import com.ebr.components.abstractdata.controller.ADataPageController;
import com.ebr.components.abstractdata.gui.ADataListPane;
import com.ebr.components.abstractdata.gui.ADataSinglePane;
import com.ebr.serverapi.BikeApi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class UserStationListPane extends ADataListPane<Station>{
	
	public UserStationListPane(ADataPageController<Station> controller) {
		this.controller = controller;
	}
	
	@Override
	public void decorateSinglePane(ADataSinglePane<Station> singlePane) {
		JButton button = new JButton("Show bike");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String stationId = singlePane.getData().getStationId();
				JTabbedPane tabbedPane = (JTabbedPane)getParent().getParent();
				tabbedPane.setSelectedIndex(1);

				ADataListPane<Bike> listPane = (ADataListPane<Bike>)((JPanel)tabbedPane.getComponent(1)).getComponent(1);
				ArrayList<Bike> listAllBike = new BikeApi().getBikes(null);
				ArrayList<Bike> listBikeByStation = new ArrayList<Bike>();
				for(int i=0 ; i<listAllBike.size() ; i++) {
					if(listAllBike.get(i).getStationId().equals(stationId)) {
						listBikeByStation.add(listAllBike.get(i));
					}
				}
				listPane.updateData(listBikeByStation);
			}
		});
		singlePane.addDataHandlingComponent(button);
		
	}
}
