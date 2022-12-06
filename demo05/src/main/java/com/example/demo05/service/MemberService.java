package com.example.demo05.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo05.model.JpaMember;
import com.example.demo05.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	// 멤버변수를 final로 하고 @RequiredArgsConstructor를 사용하면
	// @Autowired역할을 함.
	private final MemberRepository memberRepository;
	
	// 추가
	public void save(JpaMember member) {
		memberRepository.save(member);  // save() : DB에 값을 insert해줌
	}
	
	// 전체보기
	public List<JpaMember> list(){
		return memberRepository.findAll();  // findAll() : 전체값을 select할 때 사용
	}
	
	// 상세보기 (select * from jpa_member where id=3)
	// Optional : null을 방지하기 위해 만들어짐.
	public JpaMember detail(Long id) { 
		return memberRepository.findById(id).get();  // get() : 있는 객체를 강제적으로 return 시켜줌
	}
	
	// 삭제 
	public void delete(Long id) {
		memberRepository.deleteById(id);  // where절이 뒤에 붙어야하기 때문에 delete뒤에 By가 붙음, By뒤에 기본키가 들어감
	}
	
	// 수정 (더티체킹)
	@Transactional // flush기능을 해줌.
	public void update(JpaMember member) {
		JpaMember m = memberRepository.findById(member.getId()).get();  // 1차 캐시에 들어있는 객체
		// 내용은 바꼈는데 DB에 반영x (@Transactional을 적기 전에)
		m.setAddr(member.getAddr());
		m.setEmail(member.getEmail());
		m.setMemo(member.getMemo());
		m.setName(member.getName());
		m.setPassword(member.getPassword());
	}
}
