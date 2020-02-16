import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	    
	    
	}
	public  void initialize() {
		txtOrderAmount.setText("Enter Order Amount");
		
	}
	public String getTxtOrderAmount() {
		return txtOrderAmount.getText();
	}
	
	@Override
	public Order createOrder() {
		double amount = Double.parseDouble(getTxtOrderAmount());
		orden = new NonCaliforniaOrder(amount);
		return orden;
		
	}
}
