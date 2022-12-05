package com.example.demo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo02.dto.BoardDTO;
import com.example.demo02.service.BoardService;

@Controller
public class HomeController {

	@Autowired
	private BoardService bservice;
	
	// home
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	// 추가폼
	@GetMapping("insert")
	public String insert() {
		return "insert";
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
		model.addAttribute("boards", bservice.list());
		model.addAttribute("count", bservice.getCount());
		return "list";
	}
	
	// 상세보기
	@GetMapping("view/{num}")
	public String view(@PathVariable int num, Model model) {  // @PathVariable : url(view/{num})에서 num값을 받아옴.
		model.addAttribute("board",bservice.findByNum(num));
		return "view";
	}
	
	// 삭제
	@DeleteMapping("delete/{num}")
	@ResponseBody  // int형으로 콜백해주기 위해서 사용
	public int delete(@PathVariable int num) {
		bservice.delete(num);
		return num;
	}
	
	// 수정폼
	@GetMapping("update/{num}")
	public String update(@PathVariable int num, Model model) {
		model.addAttribute("board",bservice.findByNum(num));
		return "update";
	}
	
	// 수정
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody BoardDTO board) {  // @RequestBody : 제이슨 형태의 값을 받아오기 위해
		bservice.update(board);
		return "success";
		
	}
}
