package com.restjpa.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restjpa.demo.Entity.Book;
import com.restjpa.demo.Service.BookServiceImpl;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class BookController {
	@Autowired
	BookServiceImpl bookServiceimpl;
	
	@GetMapping("/")
	public String home() {
		return "Jai Shree ram";
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		 List<Book> allBooks = this.bookServiceimpl.getAllBooks();
		 if(allBooks.size()==0) {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 }
		 return ResponseEntity.of(Optional.of(allBooks));
	}
	@GetMapping("/books/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable("bookId") int id) {
		Book book= this.bookServiceimpl.getBookById(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book book1=null; 
		try {
		book1=this.bookServiceimpl.addBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable int bookId) {
		Book book1=null;
		try {
			book1=this.bookServiceimpl.updateBook(book, bookId);
			return ResponseEntity.ok().body(book1);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBookById(@PathVariable int bookId) {
		try {
			this.bookServiceimpl.deleteBookById(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/books")
	public ResponseEntity<Void> deleteAllBooks() {
		try {
			this.bookServiceimpl.deleteAll();
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
}
