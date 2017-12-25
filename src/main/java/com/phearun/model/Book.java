package com.phearun.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;

    @ManyToOne/*(cascade = CascadeType.ALL)*/
    @JoinColumn(name = "library_id")
    private Library library;

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
