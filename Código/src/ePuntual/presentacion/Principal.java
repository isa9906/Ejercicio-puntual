package ePuntual.presentacion;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		Principal frame = new Principal();

		frame.setVisible(true);
	}


	public Principal() {
		create();
	}

	private void create() {
		setTitle("Settling of orders");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 403, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCrearNuevasOrdenes = new JButton("Create new orders");
		btnCrearNuevasOrdenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new OrderManager();

			    //frame.pack();
			    
			    frame.setVisible(true);
			}
		});
		btnCrearNuevasOrdenes.setBounds(20, 25, 163, 32);
		contentPane.add(btnCrearNuevasOrdenes);
		
		JButton btnModiicarUnaOrden = new JButton("Modify an order");
		btnModiicarUnaOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new ModificarOrden();

			    //frame.pack();
			    frame.setVisible(true);
			}
		});
		btnModiicarUnaOrden.setBounds(209, 25, 168, 32);
		contentPane.add(btnModiicarUnaOrden);
		
		JButton btnSalir = new JButton("Exit");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(1);
			   
			   
			}
		});
		//btnSalir.setBounds(209, 25, 168, 32);
		btnSalir.setBounds(100, 70, 168, 32);
		contentPane.add(btnSalir);
		
		setLocationRelativeTo(null);
		
		 /*try {
		      UIManager.setLookAndFeel(new WindowsLookAndFeel());
		      SwingUtilities.updateComponentTreeUI(
		        Principal.this);
		    } catch (Exception ex) {
		      System.out.println(ex);
		    }*/
	}
	
}
