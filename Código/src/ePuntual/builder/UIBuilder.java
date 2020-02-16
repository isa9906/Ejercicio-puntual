package ePuntual.builder;
import javax.swing.JPanel;

import ePuntual.visitor.Order;

public abstract class UIBuilder {
	protected Order orden;
	protected JPanel orderUI;
	public abstract void addUIControls();
	public abstract void initialize();
	public abstract Order createOrder();
	
	public JPanel getOrderUI() {
	    return orderUI;
	  }
}
