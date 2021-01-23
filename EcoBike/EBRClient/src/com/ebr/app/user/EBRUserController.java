package com.ebr.app.user;

import javax.swing.JPanel;

import com.ebr.components.bike.controller.BikePageController;
import com.ebr.components.station.controller.StationPageController;
import com.ebr.components.returnvehicle.controller.RentVehiclePageController;
import com.ebr.components.returnvehicle.controller.ReturnVehiclePageController;

public class EBRUserController {
	public EBRUserController() {
	}
	public JPanel getReturnVehiclePage() {
		//ADataPageController<Station> controller = new StationManagerPageController();
		ReturnVehiclePageController controller = new ReturnVehiclePageController();
		return controller.getDataPagePane();
	}
	
	public JPanel getRentVehiclePage() {
		//ADataPageController<Station> controller = new StationManagerPageController();
		RentVehiclePageController controller = new RentVehiclePageController();
		return controller.getDataPagePane();
	}
	
	public JPanel getStationPage() {
		//ADataPageController<Station> controller = new StationManagerPageController();
		StationPageController controller = new StationPageController();
		return controller.getDataPagePane();
	}

	public JPanel getBikePage() {
		BikePageController controller = new BikePageController();
		return controller.getDataPagePane();
	}
}
