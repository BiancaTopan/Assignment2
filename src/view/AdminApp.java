package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.BookController;
import model.Book;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AdminApp {
	
	private BookController controller;

	public JFrame frmAdminApp;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Create the application.
	 */
	public AdminApp() {
		this.controller = new BookController();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminApp = new JFrame();
		frmAdminApp.setTitle("Admin App");
		frmAdminApp.setBounds(100, 100, 450, 300);
		frmAdminApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminApp.getContentPane().setLayout(null);
		
		table = new JTable();
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
		scrollPane.setBounds(10, 109, 414, 141);
		frmAdminApp.getContentPane().add(scrollPane);
		
		JLabel lblBooks = new JLabel("Books:");
		lblBooks.setBounds(10, 79, 46, 14);
		frmAdminApp.getContentPane().add(lblBooks);
		
		JButton btnAddBook = new JButton("Add book");
		btnAddBook.setBounds(335, 75, 89, 23);
		frmAdminApp.getContentPane().add(btnAddBook);
		btnAddBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AddBook window = new AddBook();
				window.frame.setVisible(true);
				
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(236, 75, 89, 23);
		frmAdminApp.getContentPane().add(btnDelete);
		
		JButton btnEditBook = new JButton("Edit Book");
		btnEditBook.setBounds(124, 75, 89, 23);
		frmAdminApp.getContentPane().add(btnEditBook);
		addToJTable();
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
