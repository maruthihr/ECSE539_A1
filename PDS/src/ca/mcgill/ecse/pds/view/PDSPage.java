package ca.mcgill.ecse.pds.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import ca.mcgill.ecse.pds.controller.PdsController;
import ca.mcgill.ecse.pds.model.StandardPizza;
import ca.mcgill.ecse.pds.controller.InvalidInputException;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;



public class PDSPage {

	public JFrame frmPds;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField textCalorieCount;
	
	// data elements
	private String error = null;
	private JTable menuTable;

/*	*//**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PDSPage1 window = new PDSPage1();
					window.frmPds.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	*//**
	 * Create the application.
	 *//*/
	 */
	public PDSPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPds = new JFrame();
		frmPds.setTitle("PDS");
		frmPds.setBounds(100, 100, 638, 469);
		frmPds.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		
		JLabel lblAddPizza = new JLabel("Pizza:");
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblPrice = new JLabel("Price:");
		
		JLabel lblCalorieCount = new JLabel("Calorie Count:");
		
		textCalorieCount = new JTextField();
		textCalorieCount.setColumns(10);
		
		JButton btnAddPizza = new JButton("Add");
		btnAddPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPizzaButtonActionPerformed(e);
			}
		});
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePizzaButtonActionPerformed(e);
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletePizzaButtonActionPerformed(e);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(frmPds.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 587, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblAddPizza)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCalorieCount)
										.addComponent(lblName)
										.addComponent(lblPrice))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textCalorieCount, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
										.addComponent(txtPrice, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
										.addComponent(txtName, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(18)
											.addComponent(btnAddPizza, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
											.addComponent(btnUpdate)
											.addGap(18)
											.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
											.addGap(20)))
									.addGap(155)))
							.addGap(0))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAddPizza)
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrice)
						.addComponent(txtPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCalorieCount)
						.addComponent(textCalorieCount, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddPizza)
						.addComponent(btnDelete)
						.addComponent(btnUpdate))
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		menuTable = new JTable();
		menuTable.setColumnSelectionAllowed(true);
		menuTable.setCellSelectionEnabled(true);
		menuTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Price", "Calorie Count"
			}
		));
		menuTable.getColumnModel().getColumn(0).setPreferredWidth(417);
		menuTable.getColumnModel().getColumn(2).setPreferredWidth(134);
		scrollPane.setViewportView(menuTable);
		frmPds.getContentPane().setLayout(groupLayout);
	}
	
	// action listener metods
	private void addPizzaButtonActionPerformed(ActionEvent evt) {
		// clear error message
			error = null;
			
			// call the controller createStandardPizza(String name, int price, int calorieCount) 
			try {
				StandardPizza sp = PdsController.createStandardPizza(txtName.getText(), Integer.parseInt(txtPrice.getText()), Integer.parseInt(textCalorieCount.getText()));
				updateMenu();
			} catch (InvalidInputException e) {
				error = e.getMessage();
			}
			
			// update visuals
			refreshData();
		
	}
	
	
	
	private void deletePizzaButtonActionPerformed(ActionEvent evt) {
		// clear error message
			error = null;
			StandardPizza sp = StandardPizza.getWithName(txtName.getText());
			// call the controller createStandardPizza(String name, int price, int calorieCount) 
			try {
					PdsController.deleteStandardPizza(sp);
					updateMenu();
			} catch (InvalidInputException e) {
				error = e.getMessage();
			}
			
			// update visuals
			refreshData();
		
	}
	
	
	private void updatePizzaButtonActionPerformed(ActionEvent evt) {
		// clear error message
			error = null;
			
			// call the controller createStandardPizza(String name, int price, int calorieCount) 
			try {
				PdsController.updateStandardPizza(txtName.getText(), Integer.parseInt(txtPrice.getText()), Integer.parseInt(textCalorieCount.getText()));
				updateMenu();
			} catch (InvalidInputException e) {
				error = e.getMessage();
			}
			
			// update visuals
			refreshData();
		
	}
	
	private void refreshData()
	{
		txtName.setText("");
		txtPrice.setText("");
		textCalorieCount.setText("");
		
	}
	
	private void updateMenu()
	{
		
		DefaultTableModel model = (DefaultTableModel) menuTable.getModel();
		
		model.setRowCount(0);

		
		// To Update the menu with the current list of pizzas
		// Get the current list of pizzas
		for(StandardPizza standardPizza : PdsController.getStandardPizzasOnMenu())
		{
			Object[] obj = {standardPizza.getName(), standardPizza.getPrice(), standardPizza.getCalorieCount()};
			model.addRow(obj);
		}
		
		
	}
}
