package com.last_climb.climb.controller;

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
import com.last_climb.climb.services.CheckOptional;
import com.last_climb.climb.services.PrincipalToUserService;
import com.last_climb.climb.services.UtilisateurUpdateServiceImpl;

@Controller
public class MyAccountController {

	@Autowired
	private UtilisateurUpdateServiceImpl userUp;

	@Autowired
	private CheckOptional<Utilisateur> checker;

	private static final Logger logger = LoggerFactory.getLogger(MyAccountController.class);
	@Autowired
	private PrincipalToUserService principal;

	@GetMapping("/myaccount")
	public String displayAccount(Model model, HttpSession session) {
		logger.info("In the do get");

		Utilisateur user = principal.principalToDbUser();

		model.addAttribute("topolist", user.getListTopo());
		model.addAttribute("userform", new UserForm());

		return "myaccount";
	}

	@PostMapping("/myaccount")
	public String displayAccountPost(Model model, HttpSession session) {
		logger.info("In the do post");

		Utilisateur user = principal.principalToDbUser();

		model.addAttribute("topolist", user.getListTopo());
		model.addAttribute("userform", new UserForm());

		return "myaccount";
	}

	@PostMapping("/setPassword")
	public String DisplayAccountPass(UserForm userform, HttpSession session, Model model) {
		Utilisateur user = principal.principalToDbUser();

		model.addAttribute("topolist", user.getListTopo());
		model.addAttribute("userform", userform);

		String name = user.getUsername();
		String pass = user.getPassword();

		boolean isHere = checker.findAndCheck(name, pass);
		if (isHere) {
			userUp.updatePassword(user, userform);
			return "myaccount";
		} else {
			return "index";
		}
	}

	@PostMapping("/setMail")
	public String DisplayAccountMail(UserForm userform, HttpSession session, Model model) {
		Utilisateur user = principal.principalToDbUser();

		model.addAttribute("topolist", user.getListTopo());
		model.addAttribute("userform", userform);

		String name = user.getUsername();
		String pass = user.getPassword();

		boolean isHere = checker.findAndCheck(name, pass);
		if (isHere) {
			userUp.updateMail(user, userform);
			return "myaccount";
		} else {
			return "index";
		}

	}
}
