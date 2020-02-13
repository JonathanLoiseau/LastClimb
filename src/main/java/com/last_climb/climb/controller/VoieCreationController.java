package com.last_climb.climb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VoieCreationController {

	@GetMapping("/voie_creation")
	public String displayControllerVoiesCreation(Model model) {
		model.addAttribute("voiesform");
		return "voie_creation";

	}

	@PostMapping("/voie_creation")
	public String displayControllerVoiesCreationPost(Model model) {
		model.addAttribute("voiesform");
		return "voie_creation";
	}
}
