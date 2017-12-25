package com.phearun.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phearun.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer>{

}
