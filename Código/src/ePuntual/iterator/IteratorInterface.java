package ePuntual.iterator;

import java.util.Iterator;

import ePuntual.visitor.Order;

public interface IteratorInterface extends Iterator{
	
	public void initialize();
	public Order elementAt(int i);
	public boolean addOrder(Order order);
	public boolean addOrder(Order order,int i);
	public boolean deleteOrder(int i);
}
