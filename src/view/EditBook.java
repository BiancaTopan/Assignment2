package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.BookController;
import model.Book;

import javax.swing.JButton;
import javax.swing.JSpinner;

public class EditBook {
	
	private BookController controller;

	public JFrame frmEditBooks;
	private JTextField textField;
	private JButton btnEdit;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	///adau


	/**
	 * Create the application.
	 */
	public EditBook() {
		this.controller = new BookController();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditBooks = new JFrame();
		frmEditBooks.setTitle("Edit Books");
		frmEditBooks.setBounds(100, 100, 450, 300);
		frmEditBooks.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEditBooks.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(10, 33, 46, 14);
		frmEditBooks.getContentPane().add(lblTitle);
		
		textField = new JTextField();
		textField.setBounds(57, 30, 196, 20);
		frmEditBooks.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Book book = new Book();
				book.setTitle(textField.getText());
				book.setAuthor(textField.getText());
				book.setGenre(textField.getText());
				//book.setQuantity(textField.getText());
				//book.setPrice(textField.getText());
				//TODO add book
//				book.setAuthor(author);//modificat pt fiecare coloana
				try {
					controller.addBook(book);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEdit.setBounds(335, 198, 89, 23);
		frmEditBooks.getContentPane().add(btnEdit);
	    ///int i =Integer.parseInt(sp.toString() );
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(10, 77, 46, 14);
		frmEditBooks.getContentPane().add(lblAuthor);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(10, 116, 46, 14);
		frmEditBooks.getContentPane().add(lblGenre);
		
		textField_1 = new JTextField();
		textField_1.setBounds(57, 74, 196, 20);
		frmEditBooks.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(57, 113, 196, 20);
		frmEditBooks.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(10, 166, 46, 14);
		frmEditBooks.getContentPane().add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 202, 46, 14);
		frmEditBooks.getContentPane().add(lblPrice);
		
		textField_3 = new JTextField();
		textField_3.setBounds(57, 163, 197, 20);
		frmEditBooks.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(57, 199, 203, 20);
		frmEditBooks.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
	}
}
