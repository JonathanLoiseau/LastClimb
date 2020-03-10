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

import com.last_climb.climb.model.InvalidMailException;
import com.last_climb.climb.model.InvalidPasswordExeption;
import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.form.UserForm;
import com.last_climb.climb.services.CheckOptional;
import com.last_climb.climb.services.PrincipalToUserService;
import com.last_climb.climb.services.TopoGestionService;
import com.last_climb.climb.services.UtilisateurUpdateServiceImpl;

@Controller
public class MyAccountController {

	@Autowired
	private UtilisateurUpdateServiceImpl userUp;

	@Autowired
	private CheckOptional<Utilisateur> checker;

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
			try {
				userUp.updatePassword(user, userform);
			} catch (InvalidPasswordExeption e) {
				model.addAttribute("erreurPass", true);
				e.printStackTrace();
			}
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
			try {
				userUp.updateMail(user, userform);
			} catch (InvalidMailException e) {
				model.addAttribute("erreurMail", true);
				e.printStackTrace();
			}
			return "myaccount";
		} else {
			return "index";
		}

	}

	@PostMapping("/share")
	public String shareTopo(@RequestParam("iD") Long iD, Model model) {
		topoManager.share(iD);
		Utilisateur user = principal.principalToDbUser();

		model.addAttribute("topolist", user.getListTopo());
		model.addAttribute("userform", new UserForm());
		return "myaccount";

	}

	@PostMapping("/available")
	public String makeAvailableTopo(@RequestParam("iD") Long iD, Model model) {
		topoManager.share(iD);
		Utilisateur user = principal.principalToDbUser();

		model.addAttribute("topolist", user.getListTopo());
		model.addAttribute("userform", new UserForm());

		topoManager.makeAvailable(iD);
		return "myaccount";

	}
}
