package com.example.demo06.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo06.model.Board;
import com.example.demo06.model.Comment;
import com.example.demo06.repository.BoardRepository;
import com.example.demo06.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private BoardRepository boardRepository;  // replyCnt는 board에 들어있기 때문에 선언
	
	// 댓글 추가
	@Transactional // save는 자동적으로 flush가 되지만 내가 만든 insert는 flush가 자동적으로 증가x
	public void insert(Comment comment) {
		//commentRepository.save(comment);  // Repository가지고 있는 메서드

		// replyCnt + 1
		Board b = boardRepository.findById(comment.getBoard().getNum()).get();
		b.setReplyCnt(b.getReplyCnt()+1);
		
		//SQL
		commentRepository.insert(comment.getContent(), comment.getBoard().getNum(), comment.getUser().getId());
	}
	
	// 댓글 리스트
	public List<Comment> list(Long bnum){
		
		return commentRepository.findByBnum(bnum);
	}
	
	// 댓글 개수
	public int count(Long bnum) {
		
		List<Comment> clist = commentRepository.findByBnum(bnum);
		return clist.size();
	}
}
