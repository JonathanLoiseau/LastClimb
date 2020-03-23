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
import com.last_climb.climb.model.exception.CantFindUserException;
import com.last_climb.climb.model.form.CreationVoieForm;
import com.last_climb.climb.model.form.SiteForm;
import com.last_climb.climb.model.form.VoiesForm;
import com.last_climb.climb.services.ImgNameCreationService;
import com.last_climb.climb.services.PrincipalToUserService;
import com.last_climb.climb.services.StorageService;

@Controller
public class SitesCreationController {
	@Autowired
	private StorageService storageService;
	@Autowired
	private PrincipalToUserService principal;
	@Autowired
	private ImgNameCreationService imgNameCreationService;

	@GetMapping("/creation_site")
	public String displaySiteCreation(Model model, HttpSession session) {

		model.addAttribute("siteForm", new SiteForm());
		session.setAttribute("secteur", new CreationVoieForm());
		session.setAttribute("site", new SiteForm());
		session.setAttribute("voie", new VoiesForm());

		return "creation_site";
	}

	@PostMapping("/creation_site")
	public String displaySiteCreationPost(Model model, SiteForm sForm, HttpServletRequest req, HttpSession session,
			@RequestParam("file") MultipartFile file) {
		model.addAttribute("siteForm", new SiteForm());
		model.addAttribute("creationvoieform", new CreationVoieForm());
		try {
			Utilisateur user = principal.principalToDbUser();
			Long userid = user.getId();
			String idtoSave = userid.toString();
			String newName= imgNameCreationService.changeName(idtoSave,file);
			storageService.store(file, newName);
			sForm.setSiteimg(newName);
			session.setAttribute("site", sForm);

		} catch (CantFindUserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "secteur_creation";

	}

}