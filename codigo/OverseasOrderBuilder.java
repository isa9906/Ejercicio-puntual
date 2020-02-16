import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	    
	}
	public  void initialize() {
		txtOrderAmount.setText("Enter Order Amount");
		txtSH.setText("Enter Addition SH");
	}
	public String getTxtOrderAmount() {
		return txtOrderAmount.getText();
	}
	
	public String getTxtSH() {
		return txtSH.getText();
	}
	public Order createOrder() {
		double amount = Double.parseDouble(getTxtOrderAmount());
		double sh= Double.parseDouble(getTxtSH());
		orden = new CaliforniaOrder(amount, sh);
		return orden;
		
	}
}
