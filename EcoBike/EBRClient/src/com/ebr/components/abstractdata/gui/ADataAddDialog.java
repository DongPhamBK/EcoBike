package com.ebr.components.abstractdata.gui;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.ebr.components.abstractdata.controller.IDataManageController;

// ta se chinh sua mot chut o class nay
@SuppressWarnings("serial")
public abstract class ADataAddDialog<T> extends JDialog {
	protected T t;
	protected GridBagLayout layout;
	protected GridBagConstraints c = new GridBagConstraints();

	public ADataAddDialog(T t, IDataManageController<T> controller) {
		super((Frame) null, "Add", true);
		
		this.t = t;
		
		setContentPane(new JPanel());
		layout = new GridBagLayout();
		getContentPane().setLayout(layout);

		
		this.buildControls();
		
		//nut luu du lieu sau khi thay doi
		JButton saveButton = new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("save");
//				T newT1 = getNew
				T newT = getNewData();
				System.out.println("2");
				controller.create(newT);;
				ADataAddDialog.this.dispose();
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
	
	public abstract T getNewData();
}
