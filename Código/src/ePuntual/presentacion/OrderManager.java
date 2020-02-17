package ePuntual.presentacion;
import java.util.*;
import java.io.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;

import ePuntual.builder.BuilderFactory;
import ePuntual.builder.UIBuilder;
import ePuntual.builder.UIDirector;
import ePuntual.iterator.AllOrders;
import ePuntual.visitor.Order;
import ePuntual.visitor.OrderVisitor;
import jdk.nashorn.internal.runtime.ListAdapter;

public class OrderManager extends JFrame {
  public static final String newline = "\n";
  public static final String GET_TOTAL = "Get Total";
  public static final String BLANK = "";
  public static final String CREATE_ORDER = "Create Order";
  public static final String EXIT = "Exit";
  public static final String CA_ORDER = "California Order";
  public static final String NON_CA_ORDER = 
    "Non-California Order";

  public static final String OVERSEAS_ORDER = "Overseas Order";


  private JComboBox cmbOrderType;
  private JLabel lblOrderType;
  private JLabel lblTotal, lblTotalValue, lblOrderCriteria;
  private OrderVisitor objVisitor;
  private JPanel orderCriteria;
  
  
  public OrderManager() {
    super("Visitor Pattern - Example");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    //Create the visitor instance
    objVisitor = new OrderVisitor();

    cmbOrderType = new JComboBox();
    cmbOrderType.addItem(OrderManager.BLANK);
    cmbOrderType.addItem(OrderManager.CA_ORDER);
    cmbOrderType.addItem(OrderManager.NON_CA_ORDER);
    cmbOrderType.addItem(OrderManager.OVERSEAS_ORDER);

    
   


    lblOrderType = new JLabel("Order Type:");
    lblTotal = new JLabel("Result:");
    lblTotalValue =
      new JLabel("Click Create or GetTotal Button");
    lblOrderCriteria =
  	      new JLabel("Order Criteria:");
    
    //Create the open button
    JButton getTotalButton =
      new JButton(OrderManager.GET_TOTAL);
    getTotalButton.setMnemonic(KeyEvent.VK_G);
    JButton createOrderButton =
      new JButton(OrderManager.CREATE_ORDER);
    getTotalButton.setMnemonic(KeyEvent.VK_C);
    JButton exitButton = new JButton(OrderManager.EXIT);
    exitButton.setMnemonic(KeyEvent.VK_X);
    ButtonHandler objButtonHandler = new ButtonHandler(this);
    

    getTotalButton.addActionListener(objButtonHandler);
    createOrderButton.addActionListener(objButtonHandler);
    exitButton.addActionListener(new ButtonHandler());
    cmbOrderType.addActionListener(objButtonHandler);

    //For layout purposes, put the buttons in a separate panel
    JPanel buttonPanel = new JPanel();
    orderCriteria= new JPanel();
    JPanel panel = new JPanel();
    GridBagLayout gridbag2 = new GridBagLayout();
    panel.setLayout(gridbag2);
    GridBagConstraints gbc2 = new GridBagConstraints();
    panel.add(getTotalButton);
    panel.add(createOrderButton);
    panel.add(exitButton);
    gbc2.anchor = GridBagConstraints.EAST;
    gbc2.gridx = 0;
    gbc2.gridy = 0;
    gridbag2.setConstraints(createOrderButton, gbc2);
    gbc2.gridx = 1;
    gbc2.gridy = 0;
    gridbag2.setConstraints(getTotalButton, gbc2);
    gbc2.gridx = 2;
    gbc2.gridy = 0;
    gridbag2.setConstraints(exitButton, gbc2);

    //****************************************************
    GridBagLayout gridbag = new GridBagLayout();
    buttonPanel.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();

    buttonPanel.add(lblOrderType);
    buttonPanel.add(cmbOrderType);
    buttonPanel.add(lblOrderCriteria);
    buttonPanel.add(orderCriteria);
    buttonPanel.add(lblTotal);
    buttonPanel.add(lblTotalValue);

    gbc.insets.top = 5;
    gbc.insets.bottom = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gridbag.setConstraints(lblOrderType, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 0;
    gridbag.setConstraints(cmbOrderType, gbc);

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 1;
    gridbag.setConstraints(lblOrderCriteria, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 1;

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 2;
    
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 2;
    gridbag.setConstraints(orderCriteria, gbc);
    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 3;


    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 4;
    gridbag.setConstraints(lblTotal, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 4;
    gridbag.setConstraints(lblTotalValue, gbc);

    gbc.insets.left = 2;
    gbc.insets.right = 2;
    gbc.insets.top = 40;

    //****************************************************

    //Add the buttons and the log to the frame
    Container contentPane = getContentPane();

    contentPane.add(buttonPanel, BorderLayout.NORTH);
    contentPane.add(panel, BorderLayout.CENTER);
    /*try {
      UIManager.setLookAndFeel(new WindowsLookAndFeel());
      SwingUtilities.updateComponentTreeUI(OrderManager.this);
    } catch (Exception ex) {
      System.out.println(ex);
    }*/
    
    setLocationRelativeTo(null);

  }


  public void setTotalValue(String msg) {
    lblTotalValue.setText(msg);
  }
  public OrderVisitor getOrderVisitor() {
    return objVisitor;
  }
  public String getOrderType() {
    return (String) cmbOrderType.getSelectedItem();
  }
  public JComboBox getOrderTypeCtrl() {
	    return cmbOrderType;
  }

  public void displayNewUI(JPanel panel) {
	   orderCriteria.removeAll();
	   orderCriteria.add(panel);
	   orderCriteria.validate();
	   validate();
  }


} // End of class OrderManager

class ButtonHandler implements ActionListener {
	OrderManager objOrderManager;
	UIBuilder builder;
	AllOrders iterador = AllOrders.getInstance();
  
	public void actionPerformed(ActionEvent e) {
		String totalResult = null;

		if (e.getActionCommand().equals(OrderManager.EXIT)) {
	      System.exit(1);
	    }
	    if (e.getSource() == objOrderManager.getOrderTypeCtrl()) {
	    	//System.out.println("funciona");
	        String selection = objOrderManager.getOrderType();
	
	        if (selection.equals("") == false) {
	          BuilderFactory factory = new BuilderFactory();
	          //create an appropriate builder instance
	          builder = factory.getUIBuilder(selection);
	          //configure the director with the builder
	          UIDirector director = new UIDirector(builder);
	          //director invokes different builder
	          // methods
	          director.build();
	          //get the final build object
	          JPanel UIObj = builder.getOrderUI();
	          objOrderManager.displayNewUI(UIObj);
	        }
	      }
	    if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)) { 
	      
	      //Create the order
	      Order order = builder.createOrder();    
	      iterador.addOrder(order);
	      objOrderManager.setTotalValue("Order Created Successfully");
	    }
	
	    if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
	      //Get the Visitor
	      OrderVisitor visitor = objOrderManager.getOrderVisitor();
	      totalResult = new Double(iterador.getOrderTotal(visitor)).toString();
	      totalResult = " Orders Total = " + totalResult;
	      objOrderManager.setTotalValue(totalResult);
	    }
	    
	  }
	
	  public ButtonHandler() {
	  }
	  
	  public ButtonHandler(OrderManager inObjOrderManager) {
	    objOrderManager = inObjOrderManager;
	  }

} // End of class ButtonHandler

