package com.ebr.app.user;

import java.awt.BorderLayout;
import javax.swing.*;

// khoi tao giao dien
@SuppressWarnings("serial")
public class EBRUser extends JFrame {

	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 550;

	public EBRUser(EBRUserController controller) {
		JPanel rootPanel = new JPanel();
		setContentPane(rootPanel);
		
		BorderLayout layout = new BorderLayout();
		rootPanel.setLayout(layout);

		
		JTabbedPane tabbedPane = new JTabbedPane();
		rootPanel.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel stationPage = controller.getStationPage();
		JPanel rentVehiclePage = controller.getRentVehiclePage();
		JPanel renturnVehiclePage = controller.getReturnVehiclePage();
		
		tabbedPane.addTab("Station", null, stationPage, "Station");
		tabbedPane.addTab("Rent Vehicle", null, rentVehiclePage, "Rent Vehicle");
		tabbedPane.addTab("Return Vehicle", null, renturnVehiclePage, "Return Vehicle");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Eco Bike System for User");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new EBRUser(new EBRUserController());// bat dau chuong trinh
			}
		});
	}
}