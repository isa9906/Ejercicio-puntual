package ePuntual.iterator;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.Vector;

import ePuntual.visitor.Order;
import ePuntual.visitor.OrderVisitor;

public class AllOrders implements IteratorInterface {
	
	public ArrayList<Order> ordenes;
	private int apunta=0; //Apunta a la posición en donde se encuentra el siguiente (next)
	private double total;
	
	private static AllOrders instance = new AllOrders();
	
	public static AllOrders getInstance() {
		return instance;
	}
	
	private AllOrders (){
		initialize();
	}
	
	@Override
	public boolean hasNext() {
		if (apunta<ordenes.size()) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public Order next() {
		Order valor = ordenes.get(apunta);
		apunta++;
		return valor;
	}
	/*public void reemplazar (int pos, Order order) {
		ordenes.set(pos, order);
	}*/
	
	@Override
	public void initialize() {
		this.ordenes = new ArrayList<Order>();
		this.total = 0;
	}
	@Override
	public Order elementAt(int i) {
		return this.ordenes.get(i);
	}

	@Override
	public boolean addOrder(Order order) {
		this.ordenes.add(order);
		return true;
	}

	@Override
	public boolean addOrder(Order order, int i, double valorAnterior) {
		if(i>this.ordenes.size() || i<0) {
			return false;
		}
		else {
			this.ordenes.set(i, order);
			//Si la orden ya estaba liquidada, 
			//el valor de total de todas las ordenes debe ser recalculado
			if(order.getValue()!=-1) {
				order.accept(new OrderVisitor()); //se calcula de nuevo
				//se resta el valor anterior y se suma el nuevo valor de la orden
				this.total = this.total - valorAnterior + order.getValue(); 
			}
		}
		return true;
	}

	@Override
	public boolean deleteOrder(int i) {
		if(i>this.ordenes.size()-1 || i<0) {
			return false;
		}
		else {
			reorderArray(i);
		}
		return true;
	}
	
	private void reorderArray(int i) {
		this.ordenes.remove(i);
	}
	
	public double getOrderTotal(OrderVisitor visitor) {
		 while(this.hasNext()) {
			 Order order = this.next();
			 order.accept(visitor);
			 total = total +order.getValue();
		 }
		 return total;
	 }
	
	public double getOrderTotal() {
		return total;
	}
	
	public ArrayList<Order> getData(){
		return this.ordenes;
	}
	
}
