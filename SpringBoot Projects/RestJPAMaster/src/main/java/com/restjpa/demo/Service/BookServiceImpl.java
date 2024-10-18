package com.restjpa.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restjpa.demo.Entity.Book;
import com.restjpa.demo.Repository.BookRepository;
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;
	@Override
	public List<Book> getAllBooks() {
		List<Book>list=new ArrayList<>();
		try {
			list=bookRepository.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Book getBookById(int id) {
		Optional<Book> book=bookRepository.findById(id);
		return book.get();
	}

	@Override
	public Book addBook(Book book) {
		Book book1=new Book();
		try {
			book1=bookRepository.save(book);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return book1;
	}

	@Override
	public Book updateBook(Book book, int id) {
		book.setId(id);
		Book result=bookRepository.save(book);
		return result;
	}

	@Override
	public void deleteBookById(int id) {
		try {
			bookRepository.deleteById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAll() {
		Iterable<Book>list=new ArrayList<>();
		try {
			list=bookRepository.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		bookRepository.deleteAll(list);
	}

}
