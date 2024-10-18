package com.restjpa.demo.Service;

import java.util.List;

import com.restjpa.demo.Entity.Book;


public interface BookService {
	public List<Book>getAllBooks();
	public Book getBookById(int id);
	public Book addBook(Book book);
	public Book updateBook(Book book,int id);
	public void deleteBookById(int id);
	public void deleteAll();
}
