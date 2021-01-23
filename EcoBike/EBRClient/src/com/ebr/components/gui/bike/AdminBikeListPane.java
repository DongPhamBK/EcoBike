package com.ebr.components.gui.bike;

import com.ebr.bean.Bike;
import com.ebr.components.abstractdata.controller.ADataPageController;
import com.ebr.components.abstractdata.controller.IDataManageController;
import com.ebr.components.abstractdata.gui.ADataListPane;
import com.ebr.components.abstractdata.gui.ADataSinglePane;
import com.ebr.components.client.controller.AdminBikePageController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class AdminBikeListPane extends ADataListPane<Bike> {

    public AdminBikeListPane(ADataPageController<Bike> controller) {
        this.controller = controller;
    }

    @Override
    public void decorateSinglePane(ADataSinglePane<Bike> singlePane) {
        JButton button = new JButton("Edit");
        singlePane.addDataHandlingComponent(button);

        JButton deleteBtn = new JButton(("Delete"));
        singlePane.addDataHandlingComponent(deleteBtn);
        
        JButton addB = new JButton("Add");
        singlePane.addDataHandlingComponent(addB);

        IDataManageController<Bike> manageController = new IDataManageController<Bike>() {
            @Override
            public void update(Bike t) {
                if (controller instanceof AdminBikePageController) {
                    Bike newBike = ((AdminBikePageController) controller).updateBike(t);
                    singlePane.updateData(newBike);
                }
            }

            @Override
            public void create(Bike t) {
            	System.out.println("denadminListPane");
            	if (controller instanceof AdminBikePageController) {
                    Bike newBike = ((AdminBikePageController) controller).create(t);
                    System.out.print("AdminBikePage");
                    singlePane.updateData(newBike);
                }
            }

            @Override
            public void read(Bike t) {
            }

            @Override
            public void delete(Bike t) {
                if (controller instanceof AdminBikePageController) {
                    Bike newBike = ((AdminBikePageController) controller).deleteBike(t);
                    singlePane.updateData(newBike);
                }
            }
        };

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BikeEditDialog(singlePane.getData(), manageController);
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((AdminBikePageController) controller).deleteBike(singlePane.getData());
                singlePane.removeAll();
            }
        });
        
        addB.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		new BikeAddDialog(singlePane.getData(), manageController);
        	}
        });
    }
}