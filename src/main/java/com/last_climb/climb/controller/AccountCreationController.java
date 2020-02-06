package com.last_climb.climb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.last_climb.climb.model.Utilisateur;
import com.last_climb.climb.repo.UserRepo;

@Controller
public class AccountCreationController {

	@Autowired
	private UserRepo uRep;

	@GetMapping("/account")
	public String displayAccountCreationController(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		return "account";
	}

	@PostMapping("/account")
	public String AccCreate(Utilisateur user,  Model model) {
		uRep.save(user);
		String uName = user.getUsername();
		model.addAttribute("uname", uName);
		return "myaccount";
	}
}
