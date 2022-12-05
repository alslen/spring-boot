package com.example.demo02.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo02.dao.BoardMapper;
import com.example.demo02.dao.CommentMapper;
import com.example.demo02.dto.CommentDTO;

@Service  // 객체를 만드는 어노테이션
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentMapper cmapper;
	@Autowired
	private BoardMapper bmapper;
	
	// 추가
	@Override
	@Transactional  
	public void insert(CommentDTO comment) {
		// 댓글 추가
		cmapper.insert(comment);
		
		// 댓글 개수 증가
		bmapper.updateReplyCnt(comment.getBnum(),1);
		
		// @Param을 사용하거나 HashMap을 사용해서 값을 하나로 모아서 전달하거나 둘 다 가능
//		HashMap<String, Integer> hm = new HashMap<>();
//		hm.put("bnum", comment.getBnum());
//		hm.put("amount", 1);
//		bmapper.updateReplyCnt(hm);
	}

	// 댓글 전체보기
	@Override
	public List<CommentDTO> list(int bnum) {
		return cmapper.list(bnum);
	}

	// 댓글 삭제
	@Override
	@Transactional
	public void delete(int cnum) {
		// comment를 먼저 선언해줘야함. 
		CommentDTO comment = cmapper.findByNum(cnum);
		// 댓글 삭제(삭제를 먼저 하면 cnum에 대한 comment를 못구해옴.)
		cmapper.delete(cnum);
		// 댓글 수 감소
		bmapper.updateReplyCnt(comment.getBnum(), -1);
	}

}
