package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BookStore {
	
	private Connection connection;
	
	public BookStore() {
		MySqlConnector mysql = MySqlConnector.getConnection();
		connection = mysql.connection;
	}
	
	public List<Book> getBooks()throws SQLException {
		System.out.println("Creating Statement...");
		List<Book> books = new ArrayList<Book>();
		Statement stmt=connection.createStatement();
		String sqlQuery="SELECT * FROM books";
		ResultSet queryResult=stmt.executeQuery(sqlQuery);
		
		while (queryResult.next()) {
			Book book = new Book();
			book.setId(queryResult.getInt("id"));
			book.setTitle(queryResult.getString("title"));
			book.setAuthor(queryResult.getString("author"));
			book.setGenre(queryResult.getString("genre"));
			book.setQuantity(queryResult.getInt("quantity"));
			book.setPrice(queryResult.getInt("price"));
			
			books.add(book);
		}
		queryResult.close();
		stmt.close();
		return books;
	}

	public void insertBook(Book book) throws SQLException {
		String statement= "INSERT INTO books (title, author, genre, quantity, price)values (?,?,?,?,?)";
		PreparedStatement prepSt = connection.prepareStatement(statement);
		prepSt.setString(1, book.getTitle());
		prepSt.setString(2, book.getAuthor());
		prepSt.setString(3, book.getGenre());
		prepSt.setInt(4, book.getQuantity());
		prepSt.setDouble(5, book.getPrice());

          
		prepSt.executeUpdate();
	}

	public void deleteBook(Book book) throws SQLException {
		String statement= "DELETE from books where id=?";
		PreparedStatement prepSt = connection.prepareStatement(statement);
		prepSt.setInt(1, book.getId());
		prepSt.executeUpdate();
		
	}
   
	public void updateBook(Book book, String new_title, String new_author, String new_genre, int new_quantity, int new_price ) throws SQLException {
		String statement= "UPDATE books SET title=?, author=?, genre=?, quantity=?, price=? where id=?";
		PreparedStatement prepSt = connection.prepareStatement(statement);
		prepSt.setInt(1, book.getId());
		prepSt.setString(2, new_title);
		prepSt.setString(3, new_author);
		prepSt.setString(4, new_genre);
		prepSt.setInt(5, new_quantity);
		prepSt.setInt(6, new_price);
	}

	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		
	}
	
}
