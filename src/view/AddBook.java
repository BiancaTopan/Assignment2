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

public class AddBook {
	
	private BookController controller;

	public JFrame frame;
	private JTextField textField;
	private JButton btnAdd;
	private JLabel lblAuthor;
	private JTextField textField_1;
	private JLabel lblGenre;
	private JLabel lblQuantity;
	private JTextField textField_2;
	private JLabel lblPrice;
	private JTextField textField_3;
	///adau


	/**
	 * Create the application.
	 */
	public AddBook() {
		this.controller = new BookController();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(10, 28, 46, 14);
		frame.getContentPane().add(lblTitle);
		
		textField = new JTextField();
		textField.setBounds(66, 25, 185, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Book book = new Book();
				book.setTitle(textField.getText());
				//TODO add book
				try {
					controller.addBook(book);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(335, 24, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JSpinner spinner = new JSpinner();
		Object sp=spinner.getValue();
	    int i =Integer.parseInt(sp.toString() );
		spinner.setBounds(66, 165, 29, 20);
		frame.getContentPane().add(spinner);
		
		lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(10, 78, 46, 14);
		frame.getContentPane().add(lblAuthor);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 75, 185, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		lblGenre = new JLabel("Genre");
		lblGenre.setBounds(10, 128, 46, 14);
		frame.getContentPane().add(lblGenre);
		
		lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(10, 168, 46, 14);
		frame.getContentPane().add(lblQuantity);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 125, 185, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		lblPrice = new JLabel("Price");
		lblPrice.setBounds(10, 210, 46, 14);
		frame.getContentPane().add(lblPrice);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 207, 185, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
	}
}
