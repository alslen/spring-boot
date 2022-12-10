package com.example.demo07.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo07.config.auth.PrincipalUser;
import com.example.demo07.model.Member;
import com.example.demo07.repository.memberRepository;
import com.example.demo07.service.memberService;

@Controller
public class helloController {

	@Autowired
	private memberService mService;
	@Autowired
	private memberRepository mRepository;
	
	
	@GetMapping("/")
	public String home() {
		return "/member/login";
	}
	
	// 로그인 폼
	@GetMapping("login")
	public String login() {
		return "/member/login";
	}
	
	// 회원가입 폼
	@GetMapping("/register")
	public String register() {
		return "/member/register";
	}
	
	// 회원가입
	@PostMapping("register")
	@ResponseBody
	public String register(@RequestBody Member member) {
		if(mRepository.findByUsername(member.getUsername())!= null) {
			return "fail";
		}
		mService.register(member);
		return "success";
	}
	
	// 수정 폼 
	@GetMapping("view")
	public String view(Model model, @AuthenticationPrincipal PrincipalUser principal) {
		model.addAttribute("member", mRepository.findByUsername(principal.getUsername()));
		return "/member/view";
	}
	
	// 수정
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody Member member, HttpSession session) {
		mService.update(member);
		session.invalidate();
		return "success";
	}
	
	// 회원탈퇴
	@DeleteMapping("delete/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id, HttpSession session) {
		mService.delete(id);
		session.invalidate();
		return "success";
	}
	
	// 회원 목록
//	@GetMapping("list")
//	public String list(Model model) {
//		model.addAttribute("members", mService.list());
//		model.addAttribute("count", mService.count());
//		//model.addAllAttributes("member",)
//		return "/member/list";
//	}
	
	@GetMapping("list")
	public String list(Model model, @PageableDefault(size=5, sort="id", direction = Direction.DESC)Pageable pageable,
			@RequestParam(required = false, defaultValue = "")String field,
			@RequestParam(required = false, defaultValue = "")String word) {
		
		Page<Member> lists = mService.findAll(field, word, pageable);
		Long count = mService.count(field, word);
		
		model.addAttribute("member", lists);
		model.addAttribute("count", count);
		
		return "/member/list";
	}
	
	// 관리자가 회원 삭제
	@GetMapping("deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable Long id) {
		mService.delete(id);
		return "redirect:/list";
	}
}
