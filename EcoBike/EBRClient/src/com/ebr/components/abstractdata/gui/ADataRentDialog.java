package com.ebr.components.abstractdata.gui;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.ebr.bean.*;
import com.ebr.serverapi.*;

// ta se chinh sua mot chut o class nay
@SuppressWarnings("serial")
public abstract class ADataRentDialog<T> extends JDialog {
	protected T t;
	protected long deposit;
	protected GridBagLayout layout;
	protected GridBagConstraints c = new GridBagConstraints();

	public ADataRentDialog(T t) {
		super((Frame) null, "Edit", true);
		this.t  =t;
		setContentPane(new JPanel());
		layout = new GridBagLayout();
		getContentPane().setLayout(layout);

		JLabel error = new JLabel("Tiền cọc của bạn không đủ");
		error.setVisible(true);
		
		this.buildControls();
		
		//nut luu du lieu sau khi thay doi
		JButton saveButton = new JButton("Rent Vehicle");
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				User user = getNewData();
				if(!((Bike)t).getStatus().equals("Rented")) {
					if(((Bike)t).getBikeType().equals("EBIKE"))
						deposit = 700000;
					else if(((Bike)t).getBikeType().equals("BIKE"))
						deposit = 400000;
					else if(((Bike)t).getBikeType().equals("TWINBIKE"))
						deposit = 550000;
					if(user.getAccountBalance()>deposit) {
						user.setAccountBalance(user.getAccountBalance()-deposit);
						new UserApi().updateUser(user);
						((Bike)t).setStatus("Rented");
						new BikeApi().updateBike((Bike)t);
						
						Map<String,String> idCard = new HashMap<String,String>();
						idCard.put("stationId",((Bike)t).getStationId());
						Station station = new StationApi().getStation(idCard).get(0);
						
						if(((Bike)t).getBikeType().equals("EBIKE"))
							station.setNumberEBikes(station.getNumberEBikes()-1);
						else if(((Bike)t).getBikeType().equals("BIKE"))
							station.setNumberBikes(station.getNumberBikes()-1);
						else if(((Bike)t).getBikeType().equals("TWINBIKE"))
							station.setNumberTwinBikes(station.getNumberTwinBikes()-1);
						
						station.setNumberEmptyDocks(station.getNumberEmptyDocks()+1);
						new StationApi().updateStation(station);
						Rent rent = new Rent();
						rent.setBikeId(((Bike)t).getId());
						rent.setBikeType(((Bike)t).getBikeType());
						rent.setUserId(user.getUserId());
						rent.setDeposit(deposit);
						rent.setRentId(new Date().getTime()+"");
						rent.setRentTime(new Date());
						rent.setStatus(true);
						new RentApi().addRent(rent);
						JOptionPane.showMessageDialog(null,"You have successfully rented a bike.","A plain message",JOptionPane.PLAIN_MESSAGE);
						ADataRentDialog.this.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "The balance in the account is insufficient.","Inane error",JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "This bike  has been rented.","Inane error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		
		c.gridx = 1;
		c.gridy = getLastRowIndex();
		getContentPane().add(saveButton, c);
		
		
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
	
	protected int getLastRowIndex() {
		layout.layoutContainer(getContentPane());
		int[][] dim = layout.getLayoutDimensions();
	    int rows = dim[1].length;
	    return rows;
	}
	
	public abstract void buildControls();
	
	public abstract User getNewData();
}
