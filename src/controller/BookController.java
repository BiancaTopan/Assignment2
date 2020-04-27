package controller;

import java.sql.SQLException;
import java.util.List;

import model.Book;
import model.BookStore;

public class BookController {
	
	public BookStore bookStore;

	public BookController () {
		this.bookStore = new BookStore();
	}
	
	public List<Book> getBooks() throws SQLException {
		return this.bookStore.getBooks();
	}
	
	public void addBook(Book book) throws SQLException {
		this.bookStore.insertBook(book);
	}
	
	public void editBook(Book book) throws SQLException {
	this.bookStore.updateBook(book);
	}
	
	public void sellBook(Book book) {
//	this.bookStore.updateBook(book, new_title, new_author, new_genre, new_quantity, new_price);
	}
	
}
