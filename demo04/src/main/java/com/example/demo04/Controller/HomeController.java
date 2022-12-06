package com.example.demo04.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String list() {
		return "redirect:list";
	}
	
	@GetMapping("login")
	public String login() {
		return "/user/login";
	}

}
