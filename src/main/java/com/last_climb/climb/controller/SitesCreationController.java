package com.last_climb.climb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.last_climb.climb.model.form.SiteForm;

@Controller
public class SitesCreationController {

	@GetMapping("/site_creation")
	public String displaySiteCreation(Model model) {
		model.addAttribute("siteForm", new SiteForm());
		return "site_creation";

	}

	@PostMapping("/site_creation")
	public String displaySiteCreationPost(Model model, SiteForm sForm, HttpServletRequest req, HttpSession session) {
		model.addAttribute("siteForm", new SiteForm());
		req.setAttribute("sect", sForm.getNbSecteur());

		return "secteur_creation";
	}

}
