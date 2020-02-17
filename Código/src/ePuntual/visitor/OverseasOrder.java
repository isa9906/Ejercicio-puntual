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
}
