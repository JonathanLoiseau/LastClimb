package com.last_climb.climb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.last_climb.climb.model.Utilisateur;

@Controller
public class MyAccountController {

	private static final Logger logger = LoggerFactory.getLogger(MyAccountController.class);

	@GetMapping("/myaccount")
	public String displayAccount(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		return "myaccount";
	}

	@PostMapping("/myacount")
	public String DisplayAccountPost(Utilisateur user) {
		logger.debug("In the do post");
		String actualPassword = user.getPassword();

		return "/myaccount";

	}
}
