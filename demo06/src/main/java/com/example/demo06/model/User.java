package com.example.demo06.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity  // entity명은 User임
@Table(name="tbl_user6")  // 테이블명만 tbl_user6임.
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)  // 반드시 값이 들어가야함.
	private String username;
	private String password;
	private String email;
	private String role;  // 권한
	
	//@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	//private List<Board> boards;
}
