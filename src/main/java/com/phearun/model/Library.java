package com.phearun.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    
    @Embedded
    private Address address;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "libraries")
    private List<Book> books = new ArrayList<>();

    public Library(String name) {
        this.name = name;
    }

    public Library(Integer id){
        this.id = id;
    }

	@Override
	public String toString() {
		return "Library [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
    
}
