import javax.swing.JPanel;

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
