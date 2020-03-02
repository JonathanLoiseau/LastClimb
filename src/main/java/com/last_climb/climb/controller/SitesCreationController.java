package com.last_climb.climb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.form.CreationVoieForm;
import com.last_climb.climb.model.form.SiteForm;
import com.last_climb.climb.model.form.VoiesForm;
import com.last_climb.climb.services.StorageService;

@Controller
public class SitesCreationController {
	@Autowired
	private StorageService ss;

	@GetMapping("/site_creation")
	public String displaySiteCreation(Model model, HttpSession session) {

		Utilisateur user = (Utilisateur) session.getAttribute("currentUser");
		model.addAttribute("siteForm", new SiteForm());
		session.setAttribute("secteur", new CreationVoieForm());
		session.setAttribute("site", new SiteForm());
		session.setAttribute("voie", new VoiesForm());
		if (user == null) {
			return "connectez_vous_site";
		} else {
			return "site_creation";
		}

	}

	@PostMapping("/site_creation")
	public String displaySiteCreationPost(Model model, SiteForm sForm, HttpServletRequest req, HttpSession session,
			@RequestParam("file") MultipartFile file) {
		model.addAttribute("siteForm", new SiteForm());
		model.addAttribute("creationvoieform", new CreationVoieForm());
		ss.store(file);
		sForm.setSiteimg(file.getOriginalFilename());
		session.setAttribute("site", sForm);

		return "secteur_creation";
	}

}