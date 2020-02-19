package ePuntual.builder;
import javax.swing.JPanel;

import ePuntual.visitor.Order;

public abstract class UIBuilder {
	protected Order orden;
	protected JPanel orderUI;
	public abstract void addUIControls();
	//public abstract void initialize();
	public abstract Order createOrder();
	public abstract void cargarValores(String [] valores);
	protected abstract void setPlacerHolders();
	
	public JPanel getOrderUI() {
	    return orderUI;
	  }
}
