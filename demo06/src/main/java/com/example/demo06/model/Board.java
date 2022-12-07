package com.example.demo06.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name="tbl_board6")  // entity자체의 이름을 tbl_board6으로 지정
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // auto increment
	private Long num;
	private String title;
	//private String writer;
	private String content;
	
	@Column(name="regdate")
	@CreationTimestamp  // insert 시 시간 자동 저장
	@Temporal(TemporalType.TIMESTAMP)  // @Temporal:날짜 타입 매핑 / TemporalType.TIMESTAMP: 날짜와 시간, 데이터베이스 timestamp 타입과 매핑
	private Date regdate;
	private Long hitCount;  // 조회수
	private Long replyCnt;
	@OneToMany(mappedBy = "board")  // mappedBy를 지정하지 않으면 무한루프가 돌 수 있음/ board를 바라만 봐야함
	private List<Comment> comments;  // 한 게시글에 여러 답글이 올 수 잇기 때문에 List형으로 선언
	
	@ManyToOne  // 단방향(user가 무슨글을 썻는지는 몰라도 됨)
	@JoinColumn(name="user_id") 
	private User user;
	
	@PrePersist 
	public void prePerist() { // 초기 값을 지정
		this.hitCount = this.hitCount==null?0:this.hitCount;
		this.replyCnt = this.replyCnt==null?0:this.replyCnt;
	}

}
