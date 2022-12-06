package com.example.demo04.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo04.Service.BoardService;
import com.example.demo04.dto.BoardDTO;

@Controller
public class BoardController {

	@Autowired
	private BoardService bservice;
	
		// 추가폼
		@GetMapping("insert")
		@PreAuthorize("isAuthenticated()")  // 이것을 사용하기 위해 SecurityConfig파일에서 설정을 해야함. 
		public String insert() {
			return "/board/BoardInsert";
		}
		// 추가
		@PostMapping("insert")
		public String insert(BoardDTO board) {
			bservice.insert(board);
			return "redirect:list";
		}
		
		// 전체보기
		@GetMapping("list")
		public String list(Model model) {
			model.addAttribute("count", bservice.getCount());
			model.addAttribute("boards", bservice.list());
			return "/board/BoardList";
		}
		
		// 상세보기
		@GetMapping("view/{num}")
		public String view(@PathVariable int num, Model model) {
			model.addAttribute("board", bservice.findByNum(num));
			return "/board/view";
		}
}
