package com.last_climb.climb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecteurCreationController {

	@GetMapping
	public String displaySecteurCreation(Model model) {
		model.addAttribute("voiesform");
		return "secteur_creation";

	}

	@PostMapping
	public String displaySecteurCreationPost(Model model) {
		model.addAttribute("voiesform");
		return "secteur_creation";

	}
}
