package com.example.demo05.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo05.model.JpaMember;

// JpaRepository를 상속받으면 구현하지 않아도 insert작업이 이루어짐.
public interface MemberRepository extends JpaRepository<JpaMember, Long>{ //JpaRepository<Entity를 해준 class명, 기본키의 자료형>
	
}
