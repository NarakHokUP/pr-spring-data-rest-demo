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

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrSpringDataRestDemoApplicationTests {

	@Autowired
	BookRepository bookRepository;

	@Transactional
	@Test
	public void saveBookWithoutCascade() {
		Book book = new Book();
		book.setTitle("Mastering Spring MVC");
		book.setLibraries(Arrays.asList(new Library(1), new Library(2)));
		book.setAuthor(new Author(1));
		bookRepository.save(book);

		System.out.println(book);
	}
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	LibraryRepository libraryRepository;
	
	@Transactional
	@Test
	public void saveBookWithCascade() {
		/*Author auth = authorRepository.findOne(1);
		Library lib = libraryRepository.findOne(1);
		
		Book book = new Book();
		book.setTitle("The Kite Runner");
		book.setLibrary(lib);
		book.setAuthor(auth);
		
		bookRepository.save(book);
		
		System.out.println(book);*/
	}

}
