package ePuntual.presentacion;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import ePuntual.builder.BuilderFactory;
import ePuntual.builder.UIBuilder;
import ePuntual.builder.UIDirector;
import ePuntual.iterator.AllOrders;
import ePuntual.visitor.Order;
import ePuntual.visitor.OrderVisitor;


public class OrderManager extends JFrame {
  public static final String newline = "\n";
  public static final String GET_TOTAL = "Get Total";
  public static final String BLANK = "";
  public static final String CREATE_ORDER = "Create Order";
  public static final String EXIT = "Exit";
  public static final String CA_ORDER = "California Order";
  public static final String CO_ORDER = "Colombian Order";
  public static final String NON_CA_ORDER = 
    "Non-California Order";

  public static final String OVERSEAS_ORDER = "Overseas Order";


  private JComboBox cmbOrderType;
  private JLabel lblOrderType;
  private JLabel lblOrderCriteria;
  private OrderVisitor objVisitor;
  private JPanel orderCriteria;
  
  
  public OrderManager() {
    super("Create an order");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    //Create the visitor instance
    objVisitor = new OrderVisitor();

    cmbOrderType = new JComboBox();
    cmbOrderType.addItem(OrderManager.BLANK);
    cmbOrderType.addItem(OrderManager.CA_ORDER);
    cmbOrderType.addItem(OrderManager.NON_CA_ORDER);
    cmbOrderType.addItem(OrderManager.OVERSEAS_ORDER);
    cmbOrderType.addItem(OrderManager.CO_ORDER);
    
   


    lblOrderType = new JLabel("Order Type:");
    
    lblOrderCriteria =
  	      new JLabel("Order Criteria:");
    
    //Create the open button
    JButton createOrderButton =
      new JButton(OrderManager.CREATE_ORDER);
    
    ButtonHandler objButtonHandler = new ButtonHandler(this);
    

    createOrderButton.addActionListener(objButtonHandler);
    
    cmbOrderType.addActionListener(objButtonHandler);

    //For layout purposes, put the buttons in a separate panel
    JPanel buttonPanel = new JPanel();
    orderCriteria= new JPanel();
    JPanel panel = new JPanel();
    GridBagLayout gridbag2 = new GridBagLayout();
    panel.setLayout(gridbag2);
    GridBagConstraints gbc2 = new GridBagConstraints();
    panel.add(createOrderButton);
   
    gbc2.anchor = GridBagConstraints.EAST;
    gbc2.gridx = 0;
    gbc2.gridy = 0;
    gridbag2.setConstraints(createOrderButton, gbc2);
    gbc2.gridx = 1;
    gbc2.gridy = 0;
    gbc2.gridx = 2;
    gbc2.gridy = 0;
    

    //****************************************************
    GridBagLayout gridbag = new GridBagLayout();
    buttonPanel.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();

    buttonPanel.add(lblOrderType);
    buttonPanel.add(cmbOrderType);
    buttonPanel.add(lblOrderCriteria);
    buttonPanel.add(orderCriteria);
   

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
    setSize(500, 400);
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

  void displayNewUI(JPanel panel) {
	   orderCriteria.removeAll();
	   orderCriteria.add(panel);
	   orderCriteria.validate();
	   validate();
  }
  
  void reload() {
	  dispose();
	  OrderManager x = new OrderManager();
	  x.setVisible(true);
  }


} // End of class OrderManager

class ButtonHandler implements ActionListener {
	OrderManager objOrderManager;
	UIBuilder builder;
	AllOrders iterador = AllOrders.getInstance();
  
	public void actionPerformed(ActionEvent e) {

		
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
	      if(order!=null){
	    	  iterador.addOrder(order);
		      JOptionPane.showMessageDialog(null, "Order created successfully");
	      }
	      else {
	    	  JOptionPane.showMessageDialog(null, "Order couldn't be created");
	      }
	      
	      //Nueva ejemplificaci�n de la ventana
	      objOrderManager.reload();
	      
	    }    
	  }
	
	  public ButtonHandler() {
	  }
	  
	  public ButtonHandler(OrderManager inObjOrderManager) {
	    objOrderManager = inObjOrderManager;
	  }

} // End of class ButtonHandler

