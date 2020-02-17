package ePuntual.visitor;


public class ColombianOrder extends Order {
	 private double orderAmount;
	  private double cuatroPorMil;

	  public ColombianOrder() {
	  }
	  public ColombianOrder (double inp_orderAmount,
	      double inp_cuatroPorMil) {
	    orderAmount = inp_orderAmount;
	    cuatroPorMil = inp_cuatroPorMil;
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
	}


