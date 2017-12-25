package com.phearun;

import java.util.Arrays;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.phearun.model.Address;
import com.phearun.model.Author;
import com.phearun.model.Book;
import com.phearun.model.Library;
import com.phearun.repository.AuthorRepository;
import com.phearun.repository.BookRepository;
import com.phearun.repository.LibraryRepository;

@SpringBootApplication
public class PrSpringDataRestDemoApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(PrSpringDataRestDemoApplication.class, args);
	}

	private BookRepository bookRepository;
	private LibraryRepository libraryRepository;
	private AuthorRepository authorRepository;

	public PrSpringDataRestDemoApplication(BookRepository bookRepository, LibraryRepository libraryRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.libraryRepository = libraryRepository;
		this.authorRepository = authorRepository;
	}

	@Transactional
	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {

		Arrays.asList("National Library", "Hunsen Library")
				.forEach(libraryName ->{
					Library library = new Library(libraryName);
					library.setAddress(new Address("Monivong Blvd."));
					libraryRepository.save(library);
				});
		
		Arrays.asList("Antonio Sanso", "Justin Richer", "Ryan Boyd", "Tim Messerschmidt", "Matthias Biehl")
				.forEach(authorName ->{
					Author author = new Author(authorName);
					authorRepository.save(author);
				});
		
		Arrays.asList("The One Thing", "OAuth 2 in Action", "The 100$ Startup")
				.forEach(title->{
					Book book = new Book(title);
					book.setLibrary(libraryRepository.findOne(new Random().nextInt(1)+1));
					book.setAuthor(authorRepository.findOne(new Random().nextInt(4)+1));
					bookRepository.save(book);
				});
		
		authorRepository.findAll().forEach(System.out::println);
		libraryRepository.findAll().forEach(System.out::println);
		bookRepository.findAll().forEach(System.out::println);
	}
}


