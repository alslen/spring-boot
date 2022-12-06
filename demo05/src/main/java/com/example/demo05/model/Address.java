package com.example.demo05.model;

import javax.persistence.Embeddable;

@Embeddable  // 포함됨
public class Address {

	private String zipcode;
	private String address1;
	private String address2;
	
}
