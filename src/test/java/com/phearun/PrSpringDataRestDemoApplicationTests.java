package com.phearun;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.phearun.model.Author;
import com.phearun.model.Book;
import com.phearun.model.Library;
import com.phearun.repository.AuthorRepository;
import com.phearun.repository.BookRepository;
import com.phearun.repository.LibraryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrSpringDataRestDemoApplicationTests {

	@Autowired
	BookRepository bookRepository;
	
	@Test
	public void saveBookWithoutCascade() {
		Author auth = new Author();
		auth.setId(1);
		
		Library lib = new Library();
		lib.setId(1);
		
		Book book = new Book();
		book.setTitle("test");
		book.setLibrary(lib);
		book.setAuthor(auth);
		
		bookRepository.save(book);
	}
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	LibraryRepository libraryRepository;
	
	@Transactional
	@Test
	public void saveBookWithCascade() {
		Author auth = authorRepository.findOne(1);
		Library lib = libraryRepository.findOne(1);
		
		Book book = new Book();
		book.setTitle("The Kite Runner");
		book.setLibrary(lib);
		book.setAuthor(auth);
		
		bookRepository.save(book);
		
		System.out.println(book);
	}

}
