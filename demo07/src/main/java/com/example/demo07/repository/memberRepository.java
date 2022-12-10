package com.example.demo07.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo07.model.Member;

public interface memberRepository extends JpaRepository<Member, Long>{

	Member findByUsername(String username);
	
	// 아이디로 검색
	public Page<Member> findByUsernameContaining(String username, Pageable pageable);
	// 이름으로 검색
	public Page<Member> findByNameContaining(String name, Pageable pageable);
	
	// 아이디으로 검색한 개수
	@Query(value="select count(*) from tbl_member6 where username like CONCAT('%',:word,'%')", nativeQuery = true)
	public Long cntUsernameSearch(@Param("word")String word);
	
	// 이름으로 검색한 개수
	@Query(value="select count(*) from tbl_member6 where name like CONCAT('%',:word,'%')", nativeQuery = true)
	public Long cntNameSearch(@Param("word")String word);
}
