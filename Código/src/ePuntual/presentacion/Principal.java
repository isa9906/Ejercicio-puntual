package ePuntual.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

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
		setTitle("Liquidación de órdenes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 403, 113);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCrearNuevasOrdenes = new JButton("Crear nuevas ordenes");
		btnCrearNuevasOrdenes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new OrderManager();

			    //frame.pack();
			    frame.setSize(500, 400);
			    frame.setVisible(true);
			}
		});
		btnCrearNuevasOrdenes.setBounds(20, 25, 163, 32);
		contentPane.add(btnCrearNuevasOrdenes);
		
		JButton btnModiicarUnaOrden = new JButton("Modificar una orden");
		btnModiicarUnaOrden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new ModificarOrden();

			    //frame.pack();
			    frame.setVisible(true);
			}
		});
		btnModiicarUnaOrden.setBounds(209, 25, 168, 32);
		contentPane.add(btnModiicarUnaOrden);
		
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
