package com.last_climb.climb.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.last_climb.climb.model.Utilisateur;
import com.last_climb.climb.repo.UserRepo;

@Controller
public class ConnectController {

	@Autowired
	private UserRepo urep;

	@GetMapping("/connexion")
	public String displayConnect(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		return "connexion";
	}

	@PostMapping("/connexion")
	public String displayConnectPost(HttpSession session, Utilisateur user) {
		String uName = user.getUsername();
		String pass = user.getPassword();
		Optional<Utilisateur> realUser = urep.findByUsernameAndPassword(uName, pass);
		if (realUser.isPresent()) {
			session.setAttribute("uname", uName);
			session.setAttribute("pass", pass);
			return "myaccount";
		} else
			return "connexion";

	}

}
