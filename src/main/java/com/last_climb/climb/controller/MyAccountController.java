package com.last_climb.climb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.last_climb.climb.model.Utilisateur;

@Controller
public class MyAccountController {

	@GetMapping("/myaccount")
	public String displayAccount(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		return "myaccount";
	}
}
