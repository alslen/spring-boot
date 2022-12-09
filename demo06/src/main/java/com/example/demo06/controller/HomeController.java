package com.example.demo06.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo06.config.auth.PrincipalUser;
import com.example.demo06.model.User;
import com.example.demo06.repository.UserRepository;
import com.example.demo06.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {

	private final UserService userService;  // @Autowired와 같은 역할을 함.(생성자로 만들어짐)
	private final UserRepository userRepository;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/board/list";
	}
	
	// 로그인 폼
	@GetMapping("/login")
	public String login() {
		return"/user/login";
	}
	
	// 회원가입 폼
	@GetMapping("register")
	public String register() {
		return "/user/join";
	}
	
	// 회원가입
	@PostMapping("register")
	@ResponseBody
	public String register(@RequestBody User user) {
		// username이 있으면 fail 리턴
		if(userRepository.findByUsername(user.getUsername())!=null)
			return "fail";
		userService.register(user);
		return "success";
	}
	
	// 회원변경 폼
	@GetMapping("memberView")
	public String view(Model model, @AuthenticationPrincipal PrincipalUser principal) {
		model.addAttribute("user", userService.findById(principal.getUsername()));
		return "/user/memberView";
	}
	
	// 탈퇴
	@DeleteMapping("memberDelete/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id, HttpSession session) {
		userService.delete(id);
		session.invalidate();
		return "success";
	}
	
	// 수정
	@PutMapping("memberUpdate")
	@ResponseBody
	public String update(User user, HttpSession session) {
		userService.update(user);
		session.invalidate();
		return "success";
	}
	
	// 관리자 회원 목록
	@GetMapping("memberList")
	public String list(Model model) {
		model.addAttribute("member", userService.findAll());
		model.addAttribute("count", userService.getCount());
		return "/user/memberList";
	}
	
	// admin이 회원 삭제
	@GetMapping("adminDelete/{id}")
	public String adminDelete(@PathVariable Long id) {
		userService.delete(id);
		return "redirect:memberList";
	}
}
