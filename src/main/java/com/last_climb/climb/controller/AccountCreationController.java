package com.last_climb.climb.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.last_climb.climb.model.exception.InvalidFormException;
import com.last_climb.climb.model.form.UserForm;
import com.last_climb.climb.services.UserFormToUserService;

@Controller
public class AccountCreationController {
	static Logger logger = LoggerFactory.getLogger(AccountCreationController.class);

	@Autowired
	private UserFormToUserService userFormToUser;

	@GetMapping("/account")
	public String displayAccountCreationController(Model model, HttpSession session) {
		model.addAttribute("userForm", new UserForm());
		return "account";
	}

	@PostMapping("/account")
	public String AccCreate(UserForm userForm, Model model, HttpSession session) throws InvalidFormException {
		try {
			userFormToUser.userCreation(userForm);
			return "index";
		} catch (InvalidFormException e) {
			logger.debug("account creation failed");
			model.addAttribute("erreur", true);

			return "account";
		}
	}
}
