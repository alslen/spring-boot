package com.example.demo01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("insert")
	public String insert() {
		return "insert";
	}
//	@PostMapping("insert")
//	public String insert() {
//		
//	}
}
