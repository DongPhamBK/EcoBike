package com.ebr.app.admin;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;

// khoi tao giao dien
@SuppressWarnings("serial")
public class EBRAdmin extends JFrame {

	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 550;

	public EBRAdmin(EBRAdminController controller) {
		JPanel rootPanel = new JPanel();
		setContentPane(rootPanel);
		
		BorderLayout layout = new BorderLayout();
		rootPanel.setLayout(layout);

		
		JTabbedPane tabbedPane = new JTabbedPane();
		rootPanel.add(tabbedPane, BorderLayout.CENTER);
		
		// cac tab trang can thiet: gom quan ly bai xe, quan ly thong tin xe, quan ly xe dang thue
		JPanel stationPage = controller.getStationManagerPage();
		tabbedPane.addTab("Stations Management", null, stationPage, "Stations Management");

		JPanel bikePage = controller.getBikeManagerPage();
		tabbedPane.addTab("Bikes Management", null,bikePage, "Bikes Management");
//		
		JPanel rentalPage = controller.getRentalManagerPage();
		tabbedPane.addTab("Bikes Renting Management", null, rentalPage, "Bikes Renting Management");
		//tabbedPane.addTab("Digital Video Discs", null, new JPanel(), "Digital Video Discs");

		//cac thuoc tinh co ban
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Eco Bike System for Administrator");
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
				new EBRAdmin(new EBRAdminController());// bat dau chuong trinh
			}
		});
	}
}