package com.ebr.components.abstractdata.gui;

import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.ebr.components.abstractdata.controller.ADataPageController;
import com.ebr.components.abstractdata.controller.AReturnVehiclePageController;

//class nay co the giu nguyen, tuong tu
@SuppressWarnings("serial")
public abstract class AReturnVehicleListPane<T> extends JScrollPane {
    private LayoutManager layout;
    protected JPanel pane;

    protected AReturnVehiclePageController<T> controller;

    public AReturnVehicleListPane() {
        pane = new JPanel();
        layout = new BoxLayout(pane, BoxLayout.Y_AXIS);
        pane.setLayout(layout);

        this.setViewportView(pane);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.getVerticalScrollBar().setUnitIncrement(20);
        this.getHorizontalScrollBar().setUnitIncrement(20);
    }

    public abstract void decorateSinglePane(AReturnVehicleSinglePane<T> singlePane);

    public void updateData(List<? extends T> list) {
        pane.removeAll();
        pane.revalidate();
        pane.repaint();

        for (T t: list) {
            AReturnVehicleSinglePane<T> singlePane = controller.createSinglePane();
            decorateSinglePane(singlePane);

            singlePane.updateData(t);
            pane.add(singlePane);
            pane.add(Box.createRigidArea(new Dimension(0, 40)));
        }
    }
}
