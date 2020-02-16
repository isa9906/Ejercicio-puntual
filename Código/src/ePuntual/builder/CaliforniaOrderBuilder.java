package ePuntual.builder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

import ePuntual.visitor.CaliforniaOrder;
import ePuntual.visitor.Order;

public class CaliforniaOrderBuilder extends UIBuilder {
	private JLabel lblOrderAmount, lblTax;
	private JTextField txtOrderAmount, txtTax;
	
	
	public void addUIControls() {
		orderUI=new JPanel();
		lblOrderAmount = new JLabel("Order Amount: ");
		lblTax= new JLabel ("Additional Tax: ");
		txtOrderAmount= new JTextField(20);
		txtTax= new JTextField(20);
		
		
		
		GridBagLayout gridbag = new GridBagLayout();
	    orderUI.setLayout(gridbag);
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.anchor = GridBagConstraints.WEST;
	    orderUI.add(lblOrderAmount);
	    orderUI.add(txtOrderAmount);
	    orderUI.add(lblTax);
	    orderUI.add(txtTax);
	    
	    gbc.insets.top = 5;
	    gbc.insets.bottom = 5;
	    gbc.insets.left = 5;
	    gbc.insets.right = 5;

	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gridbag.setConstraints(lblOrderAmount, gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gridbag.setConstraints(lblTax, gbc);
	    

	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    gridbag.setConstraints(txtOrderAmount, gbc);
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	    gridbag.setConstraints(txtTax, gbc);
	    
	}
	public  void initialize() {
		txtOrderAmount.setText("Enter Order Amount");
		txtTax.setText("Enter Addition tax");
	}
	public String getTxtOrderAmount() {
		return txtOrderAmount.getText();
	}
	
	public String getTxtTax() {
		return txtTax.getText();
	}
	public Order createOrder() {
		double amount = Double.parseDouble(getTxtOrderAmount());
		double tax= Double.parseDouble(getTxtTax());
		orden = new CaliforniaOrder(amount, tax);
		return orden;
		
	}
	
	
	
	
}
