package ePuntual.visitor;

public class OrderVisitor implements VisitorInterface {

  public OrderVisitor() {
	  
  }
  public void visit(NonCaliforniaOrder inp_order) {
	  inp_order.setValue(inp_order.getOrderAmount());
  }
  public void visit(CaliforniaOrder inp_order) {
	  inp_order.setValue(inp_order.getOrderAmount() + inp_order.getAdditionalTax());
  }
  public void visit(OverseasOrder inp_order) {
	  inp_order.setValue(inp_order.getOrderAmount() +inp_order.getAdditionalSH());
  }
  public void visit(ColombianOrder inp_order) {
	  inp_order.setValue(inp_order.getOrderAmount() +inp_order.getCuatroPorMil());
  }
}
