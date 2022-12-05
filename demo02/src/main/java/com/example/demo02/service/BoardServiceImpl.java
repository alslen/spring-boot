package com.example.demo02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo02.dao.BoardMapper;
import com.example.demo02.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper bmapper;
	
	// 추가
	@Override
	public void insert(BoardDTO board) {
		bmapper.insert(board);
		
	}

	// 전체보기
	@Override
	public List<BoardDTO> list() {
		return bmapper.list();
	}

	// 상세보기
	@Override
	public BoardDTO findByNum(int num) {
		return bmapper.view(num);
	}

	// 수정
	@Override
	public void update(BoardDTO board) {
		bmapper.update(board);
	}

	// 삭제
	@Override
	public void delete(int num) {
		bmapper.delete(num);
	}

	// 개수
	@Override
	public int getCount() {
		
		return bmapper.getCount();
	}

}
