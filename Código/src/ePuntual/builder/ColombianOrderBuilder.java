package ePuntual.builder;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ePuntual.visitor.ColombianOrder;
import ePuntual.visitor.Order;

public class ColombianOrderBuilder extends UIBuilder {
	private JLabel lblOrderAmount, lblCuatroPorMil;
	private JTextField txtOrderAmount, txtCuatroPorMil;
	
	
	public void addUIControls() {
		orderUI=new JPanel();
		lblOrderAmount = new JLabel("Order Amount: ");
		lblCuatroPorMil= new JLabel ("Cuatro por mil: ");
		txtOrderAmount= new JTextField(20);
		txtCuatroPorMil= new JTextField(20);
		
		
		
		GridBagLayout gridbag = new GridBagLayout();
	    orderUI.setLayout(gridbag);
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.anchor = GridBagConstraints.WEST;
	    orderUI.add(lblOrderAmount);
	    orderUI.add(txtOrderAmount);
	    orderUI.add(lblCuatroPorMil);
	    orderUI.add(txtCuatroPorMil);
	    
	    gbc.insets.top = 5;
	    gbc.insets.bottom = 5;
	    gbc.insets.left = 5;
	    gbc.insets.right = 5;

	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gridbag.setConstraints(lblOrderAmount, gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gridbag.setConstraints(lblCuatroPorMil, gbc);
	    

	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    gridbag.setConstraints(txtOrderAmount, gbc);
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	    gridbag.setConstraints(txtCuatroPorMil, gbc);
	    
	}
	public  void initialize() {
		txtOrderAmount.setText("Enter Order Amount");
		txtCuatroPorMil.setText("Enter Cuatro por mil: ");
	}
	public String getTxtOrderAmount() {
		return txtOrderAmount.getText();
	}
	
	public String getTxtCuatroPorMil() {
		return txtCuatroPorMil.getText();
	}
	public Order createOrder() {
		double amount = Double.parseDouble(getTxtOrderAmount());
		double tax= Double.parseDouble(getTxtCuatroPorMil());
		orden = new ColombianOrder(amount, tax);
		return orden;
		
	}

}
