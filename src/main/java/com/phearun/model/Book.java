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
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;

    @ManyToMany/*(cascade = CascadeType.ALL)*/
    @JoinTable(name = "book_library",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "library_id"))
    private List<Library> libraries = new ArrayList<>();

    @ManyToOne/*(cascade = CascadeType.ALL)*/
    @JoinColumn(name = "author_id")
    private Author author;
    
    public Book(String title) {
        this.title = title;
    }

	public Book(Integer id) {
		this.id = id;
	}
}
