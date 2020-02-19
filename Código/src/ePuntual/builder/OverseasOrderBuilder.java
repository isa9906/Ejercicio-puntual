package ePuntual.builder;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ePuntual.visitor.Order;
import ePuntual.visitor.OverseasOrder;

public class OverseasOrderBuilder extends UIBuilder {
	private JLabel lblOrderAmount, lblSH;
	private JTextField txtOrderAmount, txtSH;
	
	
	public void addUIControls() {
		orderUI=new JPanel();
		lblOrderAmount = new JLabel("Order Amount: ");
		lblSH= new JLabel ("Additional SH: ");
		txtOrderAmount= new JTextField(20);
		txtSH= new JTextField(20);
		
		
		
		GridBagLayout gridbag = new GridBagLayout();
	    orderUI.setLayout(gridbag);
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.anchor = GridBagConstraints.WEST;
	    orderUI.add(lblOrderAmount);
	    orderUI.add(txtOrderAmount);
	    orderUI.add(lblSH);
	    orderUI.add(txtSH);
	    
	    gbc.insets.top = 5;
	    gbc.insets.bottom = 5;
	    gbc.insets.left = 5;
	    gbc.insets.right = 5;

	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gridbag.setConstraints(lblOrderAmount, gbc);
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    gridbag.setConstraints(lblSH, gbc);
	    

	    gbc.anchor = GridBagConstraints.WEST;
	    gbc.gridx = 1;
	    gbc.gridy = 0;
	    gridbag.setConstraints(txtOrderAmount, gbc);
	    gbc.gridx = 1;
	    gbc.gridy = 1;
	    gridbag.setConstraints(txtSH, gbc);
	    
	    setPlacerHolders();
	}
	
	public  void initialize() {
		
	}
	
	public String getTxtOrderAmount() {
		return txtOrderAmount.getText();
	}
	
	public String getTxtSH() {
		return txtSH.getText();
	}
	
	public Order createOrder() {
		double amount;
		double sh;
		try {
			amount = Double.parseDouble(getTxtOrderAmount());
			sh= Double.parseDouble(getTxtSH());
			orden = new OverseasOrder(amount, sh);
			return orden;
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Error, verify data");
			return null;
		}	
	}
	
	@Override
	public void cargarValores(String[] valores) {
		txtOrderAmount.setText(valores[0]);
		txtSH.setText(valores[1]);
		
	}
	
	private void setPlacerHolders() {
		TextPrompt placeholder = new TextPrompt("Enter Order Amount", this.txtOrderAmount);
	    placeholder.changeAlpha(0.75f);
	    placeholder.changeStyle(Font.ITALIC);
	    
	    TextPrompt placeholder1 = new TextPrompt("Enter Addition SH", this.txtSH);
	    placeholder1.changeAlpha(0.75f);
	    placeholder1.changeStyle(Font.ITALIC);
	}
}
