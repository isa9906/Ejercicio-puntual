package ePuntual.visitor;

import ePuntual.presentacion.OrderManager;

public class OverseasOrder extends Order {
  private double orderAmount;
  private double additionalSH;

  public OverseasOrder() {
	  this.type = OrderManager.OVERSEAS_ORDER;
  }
  public OverseasOrder(double inp_orderAmount,
      double inp_additionalSH) {
	  this.type = OrderManager.OVERSEAS_ORDER;
	  System.out.print(this.type);
    orderAmount = inp_orderAmount;
    additionalSH = inp_additionalSH;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalSH() {
    return additionalSH;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }
	@Override
	public String[] getValues() {
		String[] valores = {Double.toString(this.orderAmount),Double.toString(this.additionalSH)};
		return valores;
	}
	@Override
	public void setValues(String[] values) {
		this.orderAmount = Double.parseDouble(values[0]);
		this.additionalSH = Double.parseDouble(values[1]);
	}
}
