package com.last_climb.climb.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.last_climb.climb.model.entity.Secteur;
import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.model.entity.Voie;
import com.last_climb.climb.model.form.CreationVoieForm;
import com.last_climb.climb.model.form.SiteForm;
import com.last_climb.climb.model.form.VoiesForm;
import com.last_climb.climb.repo.SecteurRepository;
import com.last_climb.climb.repo.SiteRepository;
import com.last_climb.climb.repo.VoieRepository;

@Controller
public class VoieCreationController {

	@Autowired
	SiteRepository srep;

	@Autowired
	SecteurRepository sectrep;

	@Autowired
	VoieRepository vrep;

	@GetMapping("/voie_creation")
	public String displayControllerVoiesCreation(Model model) {
		model.addAttribute("voiesform");
		return "voie_creation";

	}

	@Transactional
	@PostMapping("/voie_creation")
	public String displayControllerVoiesCreationPost(Model model, HttpSession session, VoiesForm vf) {

		model.addAttribute("voie", vf);
		session.setAttribute("voies", vf);

		Secteur secteur = new Secteur();
		Site site = new Site();
		Voie voie = new Voie(vf);

		voie.setSecteur(secteur);
		CreationVoieForm sessionSecteur = (CreationVoieForm) session.getAttribute("secteur");
		SiteForm sessionsite = (SiteForm) session.getAttribute("site");

		secteur.setName(sessionSecteur.getName());
		secteur.addVoie(voie);

		site.setName(sessionsite.getName());
		site.addSecteur(secteur);
		secteur.setSite(site);
		srep.save(site);
		sectrep.save(secteur);
		vrep.save(voie);

		return "result";
	}
}
