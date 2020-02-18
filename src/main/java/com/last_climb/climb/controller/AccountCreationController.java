package com.last_climb.climb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.repo.UserRepo;

@Controller
public class AccountCreationController {

	@Autowired
	private UserRepo uRep;

	@GetMapping("/account")
	public String displayAccountCreationController(Model model, HttpSession session) {
		model.addAttribute("utilisateur", new Utilisateur());
		return "account";
	}

	@PostMapping("/account")
	public String AccCreate(Utilisateur user, Model model, HttpSession session) {
		uRep.save(user);
		return "index";
	}
}
