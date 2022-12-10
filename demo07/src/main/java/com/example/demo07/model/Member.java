package com.example.demo07.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
@Table(name="tbl_member6")
public class Member {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String username;  // 아이디
	private String password;
	private String name;  // 성명
	private String email;
	private String address;
	private String phone;
	private String role; // 권한
}
