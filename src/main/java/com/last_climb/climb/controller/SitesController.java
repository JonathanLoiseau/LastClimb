package com.last_climb.climb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.form.FindSiteForm;
import com.last_climb.climb.model.form.SiteForm;

@Controller
public class SitesController {
	@GetMapping("/sites_creation")
	public String displaySitesCreation(Model model, HttpSession session) {
		model.addAttribute("siteForm", new SiteForm());
		Utilisateur user = (Utilisateur) session.getAttribute("currentUser");
		if (user == null) {
			return "connectez_vous_site";
		} else {
			return "site_creation";
		}

	}

	@GetMapping("/sites")
	public String displaySites(Model model, HttpSession session) {

		model.addAttribute("findform", new FindSiteForm());
		return "sites";

	}

	@GetMapping("/find_site")
	public String displaySiteFind(Model model, HttpSession session) {
		model.addAttribute("findform", new FindSiteForm());
		session.setAttribute("FindSite", new FindSiteForm());

		return ("find_site");
	}

	@PostMapping("/find_site")
	public String displaySiteFind(Model model, HttpSession session, FindSiteForm fs) {
		session.setAttribute("FindSite", fs);
		model.addAttribute("findform", new FindSiteForm());

		return ("index");
	}

}
