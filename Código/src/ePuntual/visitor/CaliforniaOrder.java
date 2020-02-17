package ePuntual.visitor;

import ePuntual.presentacion.OrderManager;

public class CaliforniaOrder extends Order {
	
	private double orderAmount;
	private double additionalTax;
	

	  public CaliforniaOrder() {
		  this.type = OrderManager.CA_ORDER;
	  }
	  public CaliforniaOrder(double inp_orderAmount,
	      double inp_additionalTax) {
		  this.type = OrderManager.CA_ORDER;
	    orderAmount = inp_orderAmount;
	    additionalTax = inp_additionalTax;
	  }
	  public double getOrderAmount() {
	    return orderAmount;
	  }
	  public double getAdditionalTax() {
	    return additionalTax;
	  }
	  public void accept(OrderVisitor v) {
	    v.visit(this);
	  }
}

