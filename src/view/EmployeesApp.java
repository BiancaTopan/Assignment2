package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.BookController;
import model.Book;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;

public class EmployeesApp {
	
	private BookController controller;

	public JFrame frmEmployeesApp;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the application.
	 */
	public EmployeesApp() {
		this.controller = new BookController();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmployeesApp = new JFrame();
		frmEmployeesApp.setTitle("Employees App");
		frmEmployeesApp.setBounds(100, 100, 450, 300);
		frmEmployeesApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployeesApp.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Title", "Author", "Genre", "Quantity", "Price"
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, String.class, String.class, String.class, Integer.class, Double.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			};
		table.setModel(model);
		table.setBounds(10, 77, 414, 173);
//		frame.getContentPane().add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.add(table.getTableHeader());
		scrollPane.setBounds(10, 36, 414, 141);
		frmEmployeesApp.getContentPane().add(scrollPane);
		
		JLabel lblBooks = new JLabel("Books:");
		lblBooks.setBounds(10, 11, 46, 14);
		frmEmployeesApp.getContentPane().add(lblBooks);
		
		JButton btnSell = new JButton("SELL");
		btnSell.setBounds(300, 215, 89, 23);
		frmEmployeesApp.getContentPane().add(btnSell);
		addToJTable();
		
		btnSell.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e){
				
				
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				int rowIndex = table.getSelectedRow();
				Book book = new Book();
				
				System.out.println(rowIndex);
				book.setTitle(model.getValueAt(rowIndex, 1).toString());
				book.setId(Integer.parseInt(model.getValueAt(rowIndex, 0).toString()));

				SellBooks window3 = new SellBooks();
				window3.frame.setVisible(true);
				
			}
		});
		
		table.setRowSelectionAllowed(true);
		
	}

	void addToJTable() {
		try {
			List<Book> books = this.controller.getBooks();
			for (Book book : books) {
				model.addRow(new Object[] { book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(),
						book.getQuantity(), book.getPrice() });
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}