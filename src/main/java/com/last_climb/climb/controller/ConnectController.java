package com.last_climb.climb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.last_climb.climb.model.entity.Utilisateur;

@Controller
public class ConnectController {

	private static final Logger logger = LoggerFactory.getLogger(ConnectController.class);

	@GetMapping("/connexion")
	public String displayConnect(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		return "connexion";
	}
}
