package com.last_climb.climb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

	@GetMapping("/admin")
	public String adminPage() {

		return ("admin");
	}

	@PostMapping("/admin")
	public String adminPagePost() {
		return ("admin");
	}
}
