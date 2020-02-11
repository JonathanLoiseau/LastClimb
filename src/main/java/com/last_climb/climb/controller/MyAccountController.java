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

@Controller
public class MyAccountController {

	@Autowired
	private UserRepo urep;

	private static final Logger logger = LoggerFactory.getLogger(MyAccountController.class);

	@GetMapping("/myaccount")
	public String displayAccount(Model model, HttpSession session) {
		logger.info("In the do get");
		Optional<Object> currentUser = Optional.ofNullable(session.getAttribute("currentUser"));
//		Optional<Optional<Utilisateur>>checkUser=(currentUser);
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
		model.addAttribute("userform", userform);
		Utilisateur user = (Utilisateur) session.getAttribute("currentUser");
		String pass = user.getPassword();
		String uName = user.getUsername();
		Optional<Utilisateur> newUser = urep.findByUsernameAndPassword(uName, pass);
		String newPass = userform.getNewPassword();
		Utilisateur uToUpdate = newUser.get();
		uToUpdate.setPassword(newPass);
		urep.save(uToUpdate);
		return "myaccount";

	}
}
