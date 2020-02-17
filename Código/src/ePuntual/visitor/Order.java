package ePuntual.visitor;
public abstract class Order {
	protected double value = -1;
	protected String type;
	public abstract void accept(OrderVisitor v);
	
	public double getValue() {
		return this.value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	public String getType() {
		return this.type;
	}
}
