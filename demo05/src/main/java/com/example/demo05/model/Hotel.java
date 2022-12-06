package com.example.demo05.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotel {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)  // auto increment
	private Long id;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Grade grade;
	
	@Embedded  // 포함시킴
	private Address address;
	
	@OneToMany(mappedBy = "hotel")  // 외래키로 지정하지 않는 테이블은 바라만 보게 해야함.
	private List<Review> reviews;
}
