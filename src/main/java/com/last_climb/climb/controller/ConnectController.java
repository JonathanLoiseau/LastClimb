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

import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.form.UserForm;
import com.last_climb.climb.repo.UserRepo;

@Controller
public class ConnectController {

	private static final Logger logger = LoggerFactory.getLogger(MyAccountController.class);
	@Autowired
	private UserRepo urep;

	@GetMapping("/connexion")
	public String displayConnect(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		return "connexion";
	}

	@PostMapping("/connexion")
	public String displayConnectPost(HttpSession session, Utilisateur user, Model model) {
		logger.info("inthedopost");
		String uName = user.getUsername();
		String pass = user.getPassword();
		Optional<Utilisateur> realUser = urep.findByUsernameAndPassword(uName, pass);
		if (realUser.isPresent()) {
			session.setAttribute("currentUser", user);
			model.addAttribute("userform", new UserForm(user));
			return "myaccount";
		} else
			return "topo";

	}

}
