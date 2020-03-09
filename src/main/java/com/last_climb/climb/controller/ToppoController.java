package com.last_climb.climb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToppoController {

	@GetMapping("/topo")
	public String displayToppo(Model model) {
		return "topo";
	}

}
