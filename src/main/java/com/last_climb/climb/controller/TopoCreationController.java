package com.last_climb.climb.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.last_climb.climb.model.entity.Topo;
import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.form.UserForm;
import com.last_climb.climb.services.PrincipalToUserService;
import com.last_climb.climb.services.TopoCreator;

@Controller
public class TopoCreationController {

	@Autowired
	private TopoCreator tCreate;
	@Autowired
	private PrincipalToUserService principal;

	@GetMapping("/topo_creation")
	public String DisplayTopoCreation(Model model, HttpSession session) {
		model.addAttribute("topo", new Topo());
		return "topo_creation";
	}

	@Transactional
	@PostMapping("/topo_creation")
	public String DisplayTopoCreationPost(Model model, HttpSession session, Topo topo) {

		model.addAttribute("topo", new Topo());
		model.addAttribute("userform", new UserForm());
		session.setAttribute("topo", topo);

		Utilisateur user = principal.principalToUser();

		tCreate.topoCreator(topo, user);

		return "redirect:/myaccount";

	}

}
