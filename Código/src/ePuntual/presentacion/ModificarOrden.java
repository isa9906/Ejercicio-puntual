package ePuntual.presentacion;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ePuntual.iterator.AllOrders;
import ePuntual.visitor.Order;
import ePuntual.visitor.OrderVisitor;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import ePuntual.builder.*;
import javax.swing.JLabel;


public class ModificarOrden extends JFrame {

	private JPanel contentPane;
	private JTable orderTable;
	private DefaultTableModel model;
	private JButton btnActualizar;
	private JPanel orderPanel;
	
	private Order actualOrder;
	private boolean selecionado=false;
	private UIBuilder builder;
	private JLabel lblTotal;
	private JButton btnGetTotal;

	public ModificarOrden() {
		create();
		cargarOrdenes();
	}

	private void create() {
		setTitle("Modify an order");
		model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] {"ID","Order type","Value"});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 935, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		orderTable = new JTable(model);
		orderTable.setBounds(33, 65, 144, 143);
		orderTable.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e) {cargarOrden();}});
				
		
		
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(15, 11, 403, 194);
		scrollPane.setViewportView(orderTable);
		scrollPane.getViewport().setView(orderTable);
		contentPane.add(scrollPane);
		
		btnActualizar = new JButton("Update");
		btnActualizar.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {cargarOrdenes();}});
		btnActualizar.setBounds(439, 11, 106, 36);
		contentPane.add(btnActualizar);
		
		orderPanel = new JPanel();
		orderPanel.setBounds(566, 11, 343, 142);
		contentPane.add(orderPanel);
		
		JButton btnModificar = new JButton("Modify order");
		btnModificar.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {submitOrder();}});
		btnModificar.setBounds(609, 164, 123, 36);
		contentPane.add(btnModificar);
		
		JButton btnEliminarOrden = new JButton("Delete order");
		btnEliminarOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminarOrden();
			}
		});
		btnEliminarOrden.setBounds(755, 164, 123, 36);
		contentPane.add(btnEliminarOrden);
		
		lblTotal = new JLabel("");
		lblTotal.setBounds(15, 228, 327, 27);
		contentPane.add(lblTotal);
		
		btnGetTotal = new JButton("Calculate Total");
		btnGetTotal.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {getTotal();}});
		btnGetTotal.setBounds(439, 223, 123, 36);
		contentPane.add(btnGetTotal);
		

		setLocationRelativeTo(null);

	}
	
	private void cargarOrdenes() {
		reiniciarModelo();
		AllOrders iterator = AllOrders.getInstance();
		ArrayList<Order> ordenes = iterator.getOrdenes();
		int size = ordenes.size();
		for(int i=0;i<size;i++) {
			Order order = ordenes.get(i);
			String value="";
			if(order.getValue()==-1) {
				value = "No settled";
			}
			else {
				value = Double.toString(order.getValue());
			}
			this.model.addRow(new Object[] {i+1,order.getType(),value});
		}
		
		//Total ordenes
		
		lblTotal.setText("Total: "+ iterator.getOrderTotal());
	}
	
	private void reiniciarModelo() {
		int rows = model.getRowCount();
		for(int i=0;i<rows;i++) {
			this.model.removeRow(0);
		}
	}
	
	private void cargarOrden() {
		this.selecionado = true;
		int orderID = (Integer) orderTable.getValueAt(orderTable.getSelectedRow(), 0); //ID de la orden seleccionada
		AllOrders iterador = AllOrders.getInstance();
		this.actualOrder = iterador.elementAt(orderID-1);
		
		BuilderFactory factory = new BuilderFactory();
		//System.out.println(order.getType());
		this.builder = factory.getUIBuilder(this.actualOrder.getType());
		UIDirector director = new UIDirector(builder);
		director.build();
		
		//se redimensiona el nuevo panel
		JPanel newPanel = builder.getOrderUI();
		newPanel.setBounds(orderPanel.getBounds());
		
		//se carga en el panel los valores de la orden seleccionada
		builder.cargarValores(this.actualOrder.getValues());
		
		//se agrega el nuevo panel en pantalla
		orderPanel.removeAll();
		orderPanel.add(newPanel);
		orderPanel.validate();
		validate();
		
	}
	
	private void submitOrder() {
		try {
			if(!this.selecionado) {
				JOptionPane.showMessageDialog(null, "Error, no order selected");
			}
			else {
				int orderID = (Integer) orderTable.getValueAt(orderTable.getSelectedRow(), 0); //ID de la orden seleccionada
				String orderValue = (String) orderTable.getValueAt(orderTable.getSelectedRow(), 2);
				double value;
				//Valor de la orden
				try {
					value = Double.parseDouble(orderValue);
				}
				catch(NumberFormatException e) {
					value = -1;
				}
				
				AllOrders iterador = AllOrders.getInstance();
				
				Order order = this.builder.createOrder();
				order.setValue(value);
				
				
				iterador.addOrder(order, orderID-1,value);
				
				JOptionPane.showMessageDialog(null, "Orden modified successfully");
				
				//Despliega nueva ejemplificación de la ventana
				dispose();
				ModificarOrden x = new ModificarOrden();
				x.setVisible(true);
			}
		}
		catch(NumberFormatException | NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Error, verify data");
		}
	}
	
	private void eliminarOrden() {
		if(this.selecionado==false){
			JOptionPane.showMessageDialog(null, "Error, no order selected");
		}
		else {
			int orderID = (Integer) orderTable.getValueAt(orderTable.getSelectedRow(), 0); //ID de la orden seleccionada
			System.out.println("ID de orden eliminada: "+orderID);
			
			AllOrders iterator = AllOrders.getInstance();
			iterator.deleteOrder(orderID-1);
			JOptionPane.showMessageDialog(null, "Orden deleted successfully");
			
			//Despliega nueva ejemplificación de la ventana
			
			dispose();
			ModificarOrden x = new ModificarOrden();
			x.setVisible(true);
		}
	}
	
	private void getTotal() {
		AllOrders iterator = AllOrders.getInstance();
		iterator.getOrderTotal(new OrderVisitor());
		cargarOrdenes();
	}
}
