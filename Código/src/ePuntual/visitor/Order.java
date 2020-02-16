package ePuntual.visitor;
public abstract class Order {
	protected double value;
	public abstract void accept(OrderVisitor v);
	
	public double getValue() {
		return this.value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
}
