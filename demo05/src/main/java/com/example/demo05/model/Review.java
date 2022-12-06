package com.example.demo05.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hotel_review")  // 테이블의 이름이 hotel_review로 만들어짐
public class Review {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int rate;
	private String comment;
	private Date ratingDate;
	
	@JoinColumn(name="hotel_id")  // 외래키 지정
	@ManyToOne  // 앞이 자신이라고 생각해라.
	private Hotel hotel;
}
