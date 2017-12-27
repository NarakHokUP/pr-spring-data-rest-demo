
package com.phearun.rest;

import com.phearun.model.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

	/*@PutMapping("/books/{id}")
	public ResponseEntity<Book> putItemResource1(@PathVariable Integer id, @RequestBody Book newBook){
		Book book = bookRepository.findOne(id);
		
		book.setTitle(newBook.getTitle());
		book.setAuthor(authorRepository.findOne(newBook.getAuthor().getId()));
		book.setLibrary(libraryRepository.findOne(newBook.getLibrary().getId()));
		
		bookRepository.save(book);
		
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}*/
	
	/*
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> putItemResource2(@PathVariable Integer id, @RequestBody Book newBook){
		Book book = bookRepository.findOne(id);
		if(book != null){
			newBook.setId(id);
			bookRepository.save(newBook);
			return new ResponseEntity<Book>(book, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}*/

	private RepositoryEntityLinks entityLinks;

	public BookRestController(BookRepository bookRepository, LibraryRepository libraryRepository, AuthorRepository authorRepository, RepositoryEntityLinks entityLinks) {
		this.bookRepository = bookRepository;
		this.libraryRepository = libraryRepository;
		this.authorRepository = authorRepository;
		this.entityLinks = entityLinks;
	}

	@GetMapping("/books")
	public ResponseEntity<?> getCollectionResource(Pageable pageable){
		Page<Book> books = bookRepository.findAll(pageable);

		Resource<Page<Book>> resource = new Resource<>(books);

		resource.add(entityLinks.linkFor(Book.class).withSelfRel());
		resource.add(entityLinks.linkToSingleResource(Book.class, 1));
		resource.add(entityLinks.linkToCollectionResource(Book.class));
		resource.add(entityLinks.linksToSearchResources(Book.class));
		resource.add(entityLinks.linkToPagedResource(Book.class, pageable));

		return ResponseEntity.ok(resource);
	}
}
