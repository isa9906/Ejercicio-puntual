package ePuntual.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ePuntual.iterator.AllOrders;
import ePuntual.visitor.Order;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import ePuntual.builder.*;


public class ModificarOrden extends JFrame {

	private JPanel contentPane;
	private JTable orderTable;
	private DefaultTableModel model;
	private JButton btnActualizar;
	private JPanel orderPanel;
	private JButton button;

	
	public ModificarOrden() {
		create();
		cargarOrdenes();
	}

	private void create() {
		setTitle("Modificar una orden");
		model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] {"ID","Order type","Value"});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 935, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		orderTable = new JTable(model);
		orderTable.setBounds(33, 65, 144, 143);
		orderTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cargarOrden();
			}
		});
				
		
		
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(15, 11, 403, 212);
		scrollPane.setViewportView(orderTable);
		scrollPane.getViewport().setView(orderTable);
		contentPane.add(scrollPane);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarOrdenes();
			}
		});
		btnActualizar.setBounds(439, 11, 106, 36);
		contentPane.add(btnActualizar);
		
		orderPanel = new JPanel();
		orderPanel.setBounds(566, 11, 343, 198);
		contentPane.add(orderPanel);
		

		setLocationRelativeTo(null);

	}
	
	private void cargarOrdenes() {
		reiniciarModelo();
		ArrayList<Order> ordenes = AllOrders.getInstance().ordenes;
		int size = ordenes.size();
		for(int i=0;i<size;i++) {
			Order order = ordenes.get(i);
			String value="";
			if(order.getValue()==-1) {
				value = "Sin liquidar";
			}
			else {
				value = Double.toString(order.getValue());
			}
			this.model.addRow(new Object[] {i+1,order.getType(),value});
		}
	}
	
	private void reiniciarModelo() {
		int rows = model.getRowCount();
		for(int i=0;i<rows;i++) {
			this.model.removeRow(0);
		}
	}
	
	private void cargarOrden() {
		int orderID = (Integer) orderTable.getValueAt(orderTable.getSelectedRow(), 0); //ID de la orden seleccionada
		AllOrders iterador = AllOrders.getInstance();
		Order order = iterador.elementAt(orderID-1);
		
		BuilderFactory factory = new BuilderFactory();
		System.out.println(order.getType());
		UIBuilder builder = factory.getUIBuilder(order.getType());
		UIDirector director = new UIDirector(builder);
		director.build();
		
		orderPanel.removeAll();
		orderPanel.add(builder.getOrderUI());
		orderPanel.validate();
		validate();
		
	}
}
