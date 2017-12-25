package com.phearun;

import com.phearun.model.Book;
import com.phearun.model.Library;
import com.phearun.repository.BookRepository;
import com.phearun.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class PrSpringDataRestDemoApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(PrSpringDataRestDemoApplication.class, args);
	}

	private BookRepository bookRepository;
	private LibraryRepository libraryRepository;

	public PrSpringDataRestDemoApplication(BookRepository bookRepository, LibraryRepository libraryRepository) {
		this.bookRepository = bookRepository;
		this.libraryRepository = libraryRepository;
	}

	@Transactional
	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {

		Arrays.asList("National Library", "Hunsen Library")
				.forEach(libraryName ->{
					Library library = new Library(libraryName);
					libraryRepository.save(library);
				});

		Arrays.asList("The One Thing", "The Highly Effective People", "The 100$ Startup")
				.forEach(title->{
					Book book = new Book(title);
					book.setLibrary(libraryRepository.findOne(new Random().nextInt(1)+1));
					bookRepository.save(book);
				});

		libraryRepository.findAll().forEach(System.out::println);
		bookRepository.findAll().forEach(System.out::println);
	}
}


