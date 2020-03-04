package com.last_climb.climb.controller;

import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.form.UserForm;
import com.last_climb.climb.repo.UserRepo;

@Controller
public class ConnectController {

	private static final Logger logger = LoggerFactory.getLogger(ConnectController.class);
	@Autowired
	private UserRepo urep;

	@GetMapping("/connexion")
	public String displayConnect(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> currentPrincipalName = authentication.getAuthorities();
		for (GrantedAuthority aut : currentPrincipalName) {
			System.out.println(aut.getAuthority());
		}
		return "connexion";
	}

	@PostMapping("/connexion")
	public String displayConnectPost(HttpSession session, Utilisateur user, Model model) {
		logger.info("inthedopost");
		Optional<Utilisateur> realUser = urep.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		if (realUser.isPresent()) {
			session.setAttribute("currentUser", realUser.get());
			model.addAttribute("userform", new UserForm(user));
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Collection<? extends GrantedAuthority> currentPrincipalName = authentication.getAuthorities();
			for (GrantedAuthority aut : currentPrincipalName) {
				System.out.println(aut.getAuthority());
			}

			return "myaccount";
		} else
			return "topo";

	}

}
