package com.last_climb.climb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SitesController {
	@GetMapping("/sites")
	public String displaySites(Model model) {

		return "sites";
	}

}
