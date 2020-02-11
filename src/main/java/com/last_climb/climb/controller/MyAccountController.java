package com.last_climb.climb.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.last_climb.climb.model.UserForm;
import com.last_climb.climb.model.Utilisateur;
import com.last_climb.climb.repo.UserRepo;
import com.last_climb.climb.services.CheckOptional;
import com.last_climb.climb.services.UtilisateurUpdateServiceImpl;

@Controller
public class MyAccountController {

	@Autowired
	private UtilisateurUpdateServiceImpl userUp;
	@Autowired
	private UserRepo urep;
	@Autowired
	private CheckOptional<Utilisateur> checker;
	private static final Logger logger = LoggerFactory.getLogger(MyAccountController.class);

	@GetMapping("/myaccount")
	public String displayAccount(Model model, HttpSession session) {
		logger.info("In the do get");
		Optional<Object> currentUser = Optional.ofNullable(session.getAttribute("currentUser"));
		if (currentUser.isPresent()) {
			model.addAttribute("utilisateur", currentUser);
		} else {
			model.addAttribute("utilisateur", new Utilisateur());
		}
		model.addAttribute("userform", new UserForm());
		return "myaccount";
	}

	@PostMapping("/myaccount")
	public String DisplayAccountPost(UserForm userform, HttpSession session, Model model) {
		Utilisateur user = (Utilisateur) session.getAttribute("currentUser");
		model.addAttribute("userform", userform);
		Utilisateur current = (Utilisateur) session.getAttribute("currentUser");
		String name = current.getUsername();
		String pass = current.getPassword();
		boolean isHere = checker.findAndCheck(name, pass);
		if (isHere) {
			userUp.update(user, userform);
			return "myaccount";
		} else {
			return "index";
		}

	}
}
