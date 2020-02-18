package ePuntual.builder;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ePuntual.visitor.CaliforniaOrder;
import ePuntual.visitor.NonCaliforniaOrder;
import ePuntual.visitor.Order;

public class NonCaliforniaOrderBuilder extends UIBuilder {
	private JLabel lblOrderAmount;
	private JTextField txtOrderAmount;
	
	
	public void addUIControls() {
		orderUI=new JPanel();
		lblOrderAmount = new JLabel("Order Amount: ");
		txtOrderAmount= new JTextField(20);
		
		
		
		GridBagLayout gridbag = new GridBagLayout();
	    orderUI.setLayout(gridbag);
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.anchor = GridBagConstraints.WEST;
	    orderUI.add(lblOrderAmount);
	    orderUI.add(txtOrderAmount);

	    
	    gbc.insets.top = 5;
	    gbc.insets.bottom = 5;
	    gbc.insets.left = 5;
	    gbc.insets.right = 5;

	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gridbag.setConstraints(lblOrderAmount, gbc);
	    
	    

	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    gridbag.setConstraints(txtOrderAmount, gbc);
	    
	    setPlacerHolders();
	    
	}
	
	public  void initialize() {
		
	}
	
	public String getTxtOrderAmount() {
		return txtOrderAmount.getText();
	}
	
	@Override
	public Order createOrder() {
		double amount;
	
		try {
			amount = Double.parseDouble(getTxtOrderAmount());
			
			orden = new NonCaliforniaOrder(amount);
			return orden;
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error, verify data");
			return null;
		}
	}
	
	@Override
	public void cargarValores(String[] valores) {
		txtOrderAmount.setText(valores[0]);
	}
	
	private void setPlacerHolders() {
		TextPrompt placeholder = new TextPrompt("Enter Order Amount", this.txtOrderAmount);
	    placeholder.changeAlpha(0.75f);
	    placeholder.changeStyle(Font.ITALIC);
	    

	}
}
