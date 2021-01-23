package com.ebr.components.client.gui.station;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.ebr.bean.Station;
import com.ebr.components.abstractdata.controller.ADataPageController;
import com.ebr.components.abstractdata.controller.IDataManageController;
import com.ebr.components.abstractdata.gui.ADataListPane;
import com.ebr.components.abstractdata.gui.ADataSinglePane;
import com.ebr.components.client.controller.StationPageController;

@SuppressWarnings("serial")
public class AdminStationListPane extends ADataListPane<Station>{
	
	public AdminStationListPane(ADataPageController<Station> controller) {
		this.controller = controller;
	}
	
	@Override
	public void decorateSinglePane(ADataSinglePane<Station> singlePane) {
		JButton button = new JButton("Edit");
		singlePane.addDataHandlingComponent(button);
		
		IDataManageController<Station> manageController = new IDataManageController<Station>() {
			@Override
			public void update(Station t) {
				if (controller instanceof StationPageController) {
				Station newStation = ((StationPageController) controller).updateStation(t);
					singlePane.updateData(newStation);
				}
			}

			@Override
			public void create(Station t) {
			}

			@Override
			public void read(Station t) {
			}

			@Override
			public void delete(Station t) {
				
			}
		};
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StationEditDialog(singlePane.getData(), manageController);
			}
		});	
	}
}
