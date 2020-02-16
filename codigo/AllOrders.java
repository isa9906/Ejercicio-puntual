import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.Vector;

public class AllOrders implements Iterator {
	private ArrayList<Order> ordenes;
	private Order nextOrder;
	int posicion=0;
	AllOrders (ArrayList <Order> ordenes){
		this.ordenes=ordenes;
		
	}
	@Override
	public boolean hasNext() {
		if (posicion<ordenes.size()) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public Order next() {
		Order valor = ordenes.get(posicion);
		 posicion++;
		 return valor;
	}
	/*public void reemplazar (int pos, Order order) {
		ordenes.set(pos, order);
	}*/
	
}
