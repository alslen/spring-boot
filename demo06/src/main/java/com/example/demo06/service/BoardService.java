package com.example.demo06.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo06.model.Board;
import com.example.demo06.model.User;
import com.example.demo06.repository.BoardRepository;

// @Transactional : flush가 자동적으로 일어남
@Transactional(readOnly = true)  // flush가 자동적으로 호출x -> DB값 변경x
@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	// 추가
	@Transactional // flush가 이루어짐.
	public void insert(Board board, User user) {
		board.setUser(user);   // Board에 user값을 넣어두고
		boardRepository.save(board);  // insert를 시킴
	}
	
	// 전체보기(페이징x)
	public List<Board> list(){
		return boardRepository.findAll();
	}
	
//	// 페이징 포함 전체보기
//	public Page<Board> findAll(Pageable pageable) {
//
//		return boardRepository.findAll(pageable);
//	}
	
//	// 개수
//	public Long count() {
//		return boardRepository.count();
//	}
	
	// 페이징 검색 전체보기
	public Page<Board> findAll(String field, String word, Pageable pageable){
		
		Page<Board> lists = boardRepository.findAll(pageable);
		if(field.equals("title")) {
			lists = boardRepository.findByTitleContaining(word, pageable);  // Like == ...Containing
		}
		else if(field.equals("content")) {
			lists = boardRepository.findByContentContaining(word, pageable);
		}
		return lists;
	}
	
	// 페이징 검색 개수
	public Long count(String field, String word) {
		
		Long count = boardRepository.count();
		if(field.equals("title")) {
			count = boardRepository.cntTitleSearch(word);  // Like == ...Containing
		}
		else if(field.equals("content")) {
			count = boardRepository.cntContentSearch(word);
		}
		return count;
	}
	
	// 상세보기
	@Transactional // 자동적으로 flush가 호출되지 않기 때문에(@Transactional(readOnly = true)) @Transactional사용함.
	public Board findById(Long num) {
		Board board = boardRepository.findById(num).get();
		board.setHitCount(board.getHitCount()+1);  // 조회수 1증가
		return board;
	}
	
	// 삭제
	@Transactional
	public void delete(Long num) {
		//boardRepository.deleteById(num);  // deleteById : 기본키를 이용해서 삭제함.
		boardRepository.deleteByNum(num);  // 기본키가 아니기 때문에 제공x -> repository에 선언해야함.
	}
	
	// 수정 ==> 더터채킹을 해줘야함(영속성 컨텍스트에 있는 값을 가져와서 값을 수정해야함)
	@Transactional
	public void update(Board board) {
		Board b = boardRepository.findById(board.getNum()).get();
		b.setContent(board.getContent());
		b.setTitle(board.getTitle());
		b.setRegdate(new Date());  // 날짜 객체를 만들어서 강제적으로 날짜를 셋팅해줌.
	}
}
