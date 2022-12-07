package com.example.demo06.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo06.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	// findBy속성이름 -> 속성이름에 맞춰서 where절에 들어감.
	// 쿼리 메서드라고 불림.
	// 기본키는 이러한 쿼리 메서드를 선언하지 않아도 됨.
	// select * from User(tbl_user6) where username='username'
	User findByUsername(String username);  // select sql문 실행
}
