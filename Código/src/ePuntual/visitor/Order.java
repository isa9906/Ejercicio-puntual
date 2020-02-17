package ePuntual.visitor;
public abstract class Order {
	protected double value = -1;
	public abstract void accept(OrderVisitor v);
	
	public double getValue() {
		return this.value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
}
