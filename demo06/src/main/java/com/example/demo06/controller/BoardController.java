package com.example.demo06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo06.config.auth.PrincipalUser;
import com.example.demo06.model.Board;
import com.example.demo06.service.BoardService;

@RequestMapping("/board/*")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 추가폼
	@PreAuthorize("isAuthenticated()")  //권한이 있으면 추가폼으로 갈 수 있음.
	@GetMapping("insert")
	public String insert() {
		return "/board/insert";
	}
	// 추가
	@PostMapping("insert")
	public String insert(Board board, @AuthenticationPrincipal PrincipalUser principal) {  // @AuthenticationPrincipal : 인증된 객체를 얻어옴
		boardService.insert(board, principal.getUser()); 
		return "redirect:list";
	}
	
	// 게시글 전체보기
//	@GetMapping("list")
//	public String list(Model model) {
//		model.addAttribute("board", boardService.list());  // board : 게시글 정보만 가지고 있음
//		model.addAttribute("count", boardService.count());
//		return "/board/list";
//	}
	
	// 게시글 전체보기 : 페이징  ==> 페이징 정보 + data(게시글 정보)
//	@GetMapping("list")
//	//@PageableDefault : 페이징을 자동적으로 해주는 어노테이션 // size : 한 페이지에 나오는 게시글 수 
//	public String list(Model model, @PageableDefault(size=5, sort="num", direction = Direction.DESC)Pageable pageable) {
//		Page<Board>lists = boardService.findAll(pageable);  
//		System.out.println("lists : "+lists);
//		model.addAttribute("board", lists);
//		model.addAttribute("count", boardService.count());
//		return"/board/list";
//	}
	
	// 게시글 전체보기 : 페이징, 검색
	@GetMapping("list")
	public String list(Model model, @PageableDefault(size=5, sort="num", direction = Direction.DESC)Pageable pageable,
			@RequestParam(required = false, defaultValue = "")String field,
			@RequestParam(required = false, defaultValue = "")String word) {
		
		Page<Board> lists = boardService.findAll(field, word, pageable); 
		Long count = boardService.count(field, word);
		
		model.addAttribute("board", lists);
		model.addAttribute("count", count);
		 
		return "/board/list";
	}
	
	//상세보기
	@GetMapping("view/{num}")
	public String view(@PathVariable Long num, Model model) {
		model.addAttribute("board", boardService.findById(num));  
		return "/board/view";
	}
	
	// 삭제
	@DeleteMapping("delete/{num}")
	@ResponseBody
	public Long delete(@PathVariable Long num) {
		boardService.delete(num);
		return num;
	}
	
	// 수정폼
	@GetMapping("update/{num}")
	public String update(@PathVariable Long num, Model model) {
		model.addAttribute("board", boardService.findById(num));
		return "/board/update";
	}
	
	// 수정
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody Board board) {
		boardService.update(board);
		return "success";
	}
}
