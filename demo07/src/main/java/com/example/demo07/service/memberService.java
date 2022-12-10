package com.example.demo07.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo07.model.Member;
import com.example.demo07.repository.memberRepository;

@Service
public class memberService {
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private memberRepository mRepository;
	
	// 회원가입
	public void register(Member member) {
		String rawPassword = member.getPassword();
		String encPassword = encoder.encode(rawPassword);
		member.setPassword(encPassword);
		member.setRole("ROLE_USER");
		mRepository.save(member);
	}
	
	// 회원수정
	@Transactional
	public void update(Member member) {
		Member m = mRepository.findById(member.getId()).get();
		m.setAddress(member.getAddress());
		m.setEmail(member.getEmail());
		m.setName(member.getPhone());
		m.setPhone(member.getPhone());
		
	}
	
	// 회원탈퇴
	public void delete(Long id) {
		mRepository.deleteById(id);
	}
	
	// 회원수
	public Long count() {
		return mRepository.count();
	}
	
	// 회원목록
	public List<Member> list(){
		return mRepository.findAll();
	}
	
	// 페이징 검색 전체보기
	public Page<Member> findAll(String field, String word, Pageable pageable){
		Page<Member> lists = mRepository.findAll(pageable);
		if(field.equals("username")) {
			lists = mRepository.findByUsernameContaining(word, pageable);
		}
		else if(field.equals("name")) {
			lists = mRepository.findByNameContaining(word, pageable);
		}
		return lists;
	}
	
	// 페이징 검색 개수
	public Long count(String field, String word){
		Long count = mRepository.count();
		if(field.equals("username")) {
			count = mRepository.cntUsernameSearch(word);
		}
		else if(field.equals("name")) {
			count = mRepository.cntNameSearch(word);
		}
		return count;
	}
	
}
