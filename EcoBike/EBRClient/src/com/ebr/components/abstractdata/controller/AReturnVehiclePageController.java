package com.ebr.components.abstractdata.controller;

import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import com.ebr.components.abstractdata.gui.*;


// muc nay giu nguyen, chung ta se chi su dung bien AData o class nay !
public abstract class AReturnVehiclePageController<T> {
    private AReturnVehiclePagePane<T> pagePane;

    public AReturnVehiclePageController() {
        AReturnVehicleSearchPane searchPane = createSearchPane();

        AReturnVehicleListPane<T> listPane = createListPane();

        searchPane.setController(new IReturnVehicleSearchController() {
            @Override
            public void search(Map<String, String> searchParams) {
                List<? extends T> list = AReturnVehiclePageController.this.search(searchParams);
                listPane.updateData(list);
            }
        });

        searchPane.fireSearchEvent();

        pagePane = new AReturnVehiclePagePane<T>(searchPane, listPane);
    }

    public JPanel getDataPagePane() {
        return pagePane;
    }


    public abstract AReturnVehicleSearchPane createSearchPane();

    public abstract List<? extends T> search(Map<String, String> searchParams);



    public abstract AReturnVehicleSinglePane<T> createSinglePane();

    public abstract AReturnVehicleListPane<T> createListPane();
}
