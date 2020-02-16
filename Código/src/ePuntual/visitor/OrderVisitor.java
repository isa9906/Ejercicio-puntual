package ePuntual.visitor;
import java.util.*;

import ePuntual.iterator.AllOrders;

class OrderVisitor implements VisitorInterface {

  public OrderVisitor() {
	  
  }
  public void visit(NonCaliforniaOrder inp_order) {
	  inp_order.setValue(inp_order.getOrderAmount()); ;
  }
  public void visit(CaliforniaOrder inp_order) {
	  inp_order.setValue(inp_order.getOrderAmount() + inp_order.getAdditionalTax());
  }
  public void visit(OverseasOrder inp_order) {
	  inp_order.setValue(inp_order.getOrderAmount() +inp_order.getAdditionalSH());
  }

  
 public double getOrderTotal(AllOrders iterador) {
	 double total = 0;
	 while(iterador.hasNext()) {
		 Order order = iterador.next();
		 total = total +order.getValue();
	 }
	 return total;
 }
}
