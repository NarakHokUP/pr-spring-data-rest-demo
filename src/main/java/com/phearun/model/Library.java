package com.phearun.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "library", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public Library(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "Library [id=" + id + ", name=" + name + "]";
	}

    /*public void setBooks(List<Book> books){
        this.books = books;
    }
    public List<Book> getBooks(){
        return books;
    }

    public void addBook(Book book){
        this.books.add(book);
        book.setLibrary(this);
    }

    public void removeBook(Book book){
        this.books.remove(book);
        book.setLibrary(null);
    }*/

    
}
