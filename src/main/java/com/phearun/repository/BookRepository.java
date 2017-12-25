package com.phearun.repository;

import com.phearun.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
