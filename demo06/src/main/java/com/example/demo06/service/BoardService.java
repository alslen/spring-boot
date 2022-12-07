package com.example.demo06.service;

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
	
	// 페이징 포함 전체보기
	public Page<Board> findAll(Pageable pageable) {

		return boardRepository.findAll(pageable);
	}
	
	// 개수
	public Long count() {
		return boardRepository.count();
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
		boardRepository.deleteById(num);
	}
}
