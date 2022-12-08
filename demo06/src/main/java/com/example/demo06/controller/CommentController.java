package com.example.demo06.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo06.config.auth.PrincipalUser;
import com.example.demo06.model.Board;
import com.example.demo06.model.Comment;
import com.example.demo06.service.CommentService;

@RestController
@RequestMapping("/reply/*")
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	// 댓글 추가
	@PostMapping("insert/{num}")
	public ResponseEntity<String> commentInsert(@PathVariable Long num, @RequestBody Comment comment,
			@AuthenticationPrincipal PrincipalUser principal) {  // @AuthenticationPrincipal:인증객체를 구해옴.
		// Bnum을 셋팅해줌.
		Board b = new Board();
		b.setNum(num);  // bnum
		comment.setBoard(b);
		
		//// ---------------- User
		// ContextHolder에 있는 인증된 객체를 하나 가져옴 
//		PrincipalUser p = (PrincipalUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		comment.setUser(p.getUser());
		
		comment.setUser(principal.getUser());
		
		commentService.insert(comment);
		return new ResponseEntity<String>("success", HttpStatus.OK);  // ResponseEntity : 전달하고자 하는 값과 상태값을 같이 전달할 수 있음.
	}
	
	// 댓글 리스트
	@GetMapping("list/{num}")
	public HashMap<String, Object> list(@PathVariable Long num) {
		System.out.println("num : "+num);
		
		HashMap<String, Object> hm = new HashMap<String,Object>();
		List<Comment> clist = commentService.list(num);
		int count = commentService.count(num);
		hm.put("clist", clist);
		hm.put("count", count);
		
		return hm;
		//return null;
	}
}
