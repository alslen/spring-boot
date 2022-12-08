package com.example.demo06.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo06.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

	// JPQL(Java Persistence Query Language) : Entity 객체를 중심으로 조회를 함
	//@Query("select sc from tbl_comment6 sc where bnum=?1") // 매개변수로 첫번째 오는 것을 조회함.(EAGER)
	@Query("select sc from tbl_comment6 sc join fetch sc.board where bnum=?1")  // LAZY(패치조인)
	public List<Comment> findByBnum(Long bnum);
	
	// 댓글 추가
	@Modifying
	// nativeQuery = true : 우리가 알 수 있는 sql문을 사용할 수 있게 함.
	@Query(value="insert into tbl_comment6(content,regdate,bnum,user_id) values(?1,now(),?2,?3)", nativeQuery = true) 
	
	public void insert(String content, Long bnum, Long user_id);
};
