package com.phearun.rest;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.phearun.model.Book;
import com.phearun.repository.AuthorRepository;
import com.phearun.repository.BookRepository;
import com.phearun.repository.LibraryRepository;

@RepositoryRestController
public class BookRestController {
	
	BookRepository bookRepository;
	LibraryRepository libraryRepository;
	AuthorRepository authorRepository;
	
	public BookRestController(BookRepository bookRepository, LibraryRepository libraryRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.libraryRepository = libraryRepository;
		this.authorRepository = authorRepository;
	}
	
	/*@PutMapping("/books/{id}")
	public ResponseEntity<Book> putItemResource1(@PathVariable Integer id, @RequestBody Book newBook){
		Book book = bookRepository.findOne(id);
		
		book.setTitle(newBook.getTitle());
		book.setAuthor(authorRepository.findOne(newBook.getAuthor().getId()));
		book.setLibrary(libraryRepository.findOne(newBook.getLibrary().getId()));
		
		bookRepository.save(book);
		
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}*/
	
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> putItemResource2(@PathVariable Integer id, @RequestBody Book newBook){
		Book book = bookRepository.findOne(id);
		if(book != null){
			newBook.setId(id);
			bookRepository.save(newBook);
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
