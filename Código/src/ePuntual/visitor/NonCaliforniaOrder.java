package ePuntual.visitor;

import ePuntual.presentacion.OrderManager;

public class NonCaliforniaOrder extends Order {
  private double orderAmount;

  public NonCaliforniaOrder() {
	  this.type = OrderManager.NON_CA_ORDER;
  }
  public NonCaliforniaOrder(double inp_orderAmount) {
    orderAmount = inp_orderAmount;
    this.type = OrderManager.NON_CA_ORDER;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }
}
