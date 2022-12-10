package com.example.demo07.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotel {

	@Id
	private String id;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Grade grade;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "hotel")
	private List<Review> reviews;
}
