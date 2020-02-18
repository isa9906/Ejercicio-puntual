package ePuntual.visitor;

import ePuntual.presentacion.OrderManager;

public class ColombianOrder extends Order {
	 private double orderAmount;
	  private double cuatroPorMil;

	  public ColombianOrder() {
	  }
	  public ColombianOrder (double inp_orderAmount,
	      double inp_cuatroPorMil) {
	    orderAmount = inp_orderAmount;
	    cuatroPorMil = inp_cuatroPorMil;
	    this.type = OrderManager.CO_ORDER;
	  }
	  public double getOrderAmount() {
	    return orderAmount;
	  }
	  public double getCuatroPorMil() {
	    return cuatroPorMil;
	  }
	  public void accept(OrderVisitor v) {
	    v.visit(this);
	  }
	@Override
	public String[] getValues() {
		return new String[] {Double.toString(orderAmount),Double.toString(cuatroPorMil)};
	}
	@Override
	public void setValues(String[] values) {
		this.orderAmount = Double.parseDouble(values[0]);
		this.cuatroPorMil = Double.parseDouble(values[1]);
		
	}
}


