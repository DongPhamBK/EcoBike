package com.ebr.app.admin;

import javax.swing.JPanel;

import com.ebr.components.bike.controller.BikeManagerPageController;
import com.ebr.components.bike.controller.RentalManagerPageController;
import com.ebr.components.station.controller.AdminStationPageController;

public class EBRAdminController {
	public EBRAdminController() {
	}
	
	public JPanel getStationManagerPage() {
		//ADataPageController<Station> controller = new StationManagerPageController();
		AdminStationPageController controller = new AdminStationPageController();
		return controller.getDataPagePane();
	}

	public JPanel getBikeManagerPage() {
		BikeManagerPageController controller = new BikeManagerPageController();
		return controller.getDataPagePane();
	}
	
	public JPanel getRentalManagerPage() {
		RentalManagerPageController controller = new RentalManagerPageController();
		return controller.getDataPagePane();
	}

}
