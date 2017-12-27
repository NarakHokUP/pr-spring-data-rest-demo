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
public class PrSpringDataRestDemoApplication{

	public static void main(String[] args) {
		SpringApplication.run(PrSpringDataRestDemoApplication.class, args);
	}

}


