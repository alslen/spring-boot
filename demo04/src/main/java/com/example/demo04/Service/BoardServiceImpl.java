package com.example.demo04.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo04.Mapper.BoardMapper;
import com.example.demo04.dto.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper bmapper;
	
	// 추가
	@Override
	public void insert(BoardDTO board) {
		bmapper.insert(board);
	}

	@Override
	public List<BoardDTO> list() {
		return bmapper.list();
	}

	@Override
	public BoardDTO findByNum(int num) {
		return bmapper.findByNum(num);
	}

	@Override
	public void update(BoardDTO board) {
		
	}

	@Override
	public void delete(int num) {
		
	}

	@Override
	public int getCount() {
		return bmapper.getCount();
	}

}
