package com.last_climb.climb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.form.SiteForm;

@Controller
public class SitesController {
	@GetMapping("/sites")
	public String displaySites(Model model, HttpSession session) {
		model.addAttribute("siteForm", new SiteForm());
		Utilisateur user = (Utilisateur) session.getAttribute("currentUser");
		if (user == null) {
			return "connectez_vous_site";
		} else {
			return "site_creation";
		}

	}

}
