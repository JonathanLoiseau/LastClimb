package com.last_climb.climb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.last_climb.climb.model.Utilisateur;

@Controller
public class ConnectController {

	@GetMapping("/connexion")
	public String displayConnect(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		return "connexion";
	}

}
