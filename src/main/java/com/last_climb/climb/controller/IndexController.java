package com.last_climb.climb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

	@GetMapping("/index")
	public String displayIndex(Model model) {

		return "index";
	}

	@PostMapping("/index")
	public String displayIndexPost(Model model) {

		return "index";
	}
}
