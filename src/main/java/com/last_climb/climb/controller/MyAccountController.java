package com.last_climb.climb.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.exception.CantFindUserException;
import com.last_climb.climb.model.exception.InvalidMailException;
import com.last_climb.climb.model.exception.InvalidPasswordExeption;
import com.last_climb.climb.model.form.UserForm;
import com.last_climb.climb.services.PrincipalToUserService;
import com.last_climb.climb.services.TopoGestionService;
import com.last_climb.climb.services.UtilisateurUpdateServiceImpl;

@Controller
public class MyAccountController {

	@Autowired
	private UtilisateurUpdateServiceImpl userUp;

	@Autowired
	private TopoGestionService topoManager;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	private static final Logger logger = LoggerFactory.getLogger(MyAccountController.class);
	@Autowired
	private PrincipalToUserService principal;

	@GetMapping("/myaccount")
	public String displayAccount(Model model, HttpSession session) {
		logger.info("In the do get");

		try {
			Utilisateur user = principal.principalToDbUser();
			model.addAttribute("topolist", user.getListTopo());
			model.addAttribute("userform", new UserForm());
		} catch (CantFindUserException e) {
			model.addAttribute("missUser", true);
			logger.error("missingUser", e);
		}
		return "myaccount";
	}

	@PostMapping("/myaccount")
	public String displayAccountPost(Model model, HttpSession session) {
		logger.info("In the do post");

		try {
			Utilisateur user = principal.principalToDbUser();
			model.addAttribute("topolist", user.getListTopo());
			model.addAttribute("userform", new UserForm());
		} catch (CantFindUserException e) {
			model.addAttribute("missUser", true);
			logger.error("missingUser", e);
		}
		return "myaccount";
	}

	@PostMapping("/setPassword")
	public String DisplayAccountPass(UserForm userform, HttpSession session, Model model) {

		try {
			Utilisateur user = principal.principalToDbUser();
			model.addAttribute("topolist", user.getListTopo());
			model.addAttribute("userform", userform);
			userUp.updatePassword(user, userform);
		} catch (InvalidPasswordExeption e) {
			model.addAttribute("erreurPass", true);
			logger.error("incorrectPassword", e);
		}

		catch (CantFindUserException e1) {
			model.addAttribute("missUser", true);
			logger.error("missingUser", e1);
		}
		return "myaccount";
	}

	@PostMapping("/setMail")
	public String DisplayAccountMail(UserForm userform, HttpSession session, Model model) {
		try {
			Utilisateur user = principal.principalToDbUser();
			model.addAttribute("topolist", user.getListTopo());
			model.addAttribute("userform", userform);

			userUp.updateMail(user, userform);
		} catch (InvalidMailException e) {
			model.addAttribute("erreurMail", true);
			logger.debug("erreurMail", e);
		} catch (CantFindUserException e1) {
			model.addAttribute("missUser", true);
			logger.debug("missingUser", e1);
		}
		return "myaccount";
	}

	@PostMapping("/share")
	public String shareTopo(@RequestParam("iD") Long iD, Model model) {
		topoManager.share(iD);
		try {
			Utilisateur user = principal.principalToDbUser();
			model.addAttribute("topolist", user.getListTopo());
			model.addAttribute("userform", new UserForm());
		} catch (CantFindUserException e) {
			model.addAttribute("missUser", true);
			logger.error("missingUser", e);
		}
		return "myaccount";

	}

	@PostMapping("/available")
	public String makeAvailableTopo(@RequestParam("iD") Long iD, Model model) {
		topoManager.share(iD);
		try {
			Utilisateur user = principal.principalToDbUser();
			model.addAttribute("topolist", user.getListTopo());
			model.addAttribute("userform", new UserForm());
			topoManager.makeAvailable(iD);
		} catch (CantFindUserException e) {
			model.addAttribute("missUser", true);
			logger.error("missingUser", e);
		}
		return "myaccount";

	}
}
