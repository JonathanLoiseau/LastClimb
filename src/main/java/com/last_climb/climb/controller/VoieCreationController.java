package com.last_climb.climb.controller;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.last_climb.climb.model.IdContainer;
import com.last_climb.climb.model.exception.NoSiteException;
import com.last_climb.climb.model.exception.SecteurNotFoundException;
import com.last_climb.climb.model.form.CreationVoieForm;
import com.last_climb.climb.model.form.SiteForm;
import com.last_climb.climb.model.form.VoiesForm;
import com.last_climb.climb.repo.SecteurRepository;
import com.last_climb.climb.repo.SiteRepository;
import com.last_climb.climb.repo.VoieRepository;
import com.last_climb.climb.services.SiteCreationService;

@Controller
public class VoieCreationController {

	@Autowired
	private SiteRepository srep;

	@Autowired
	private SecteurRepository sectrep;

	@Autowired
	private VoieRepository vrep;

	@Autowired
	private SiteCreationService scs;

	private final static Logger logger = org.slf4j.LoggerFactory.getLogger(VoieCreationController.class);

	@GetMapping("/voie_creation")
	public String displayControllerVoiesCreation(Model model) {
		model.addAttribute("voiesform");
		model.addAttribute("voie", new VoiesForm());
		System.out.println("dans le get de voiecontroleur");
		return "voie_creation";

	}

	@Transactional
	@PostMapping("/voie_creation")
	public String displayControllerVoiesCreationPost(Model model, HttpSession session, VoiesForm vf) {

		model.addAttribute("voie", vf);
		session.setAttribute("voies", vf);

		CreationVoieForm sessionSecteur = (CreationVoieForm) session.getAttribute("secteur");
		SiteForm sessionSite = (SiteForm) session.getAttribute("site");
		VoiesForm sessionVoie = (VoiesForm) session.getAttribute("voies");
		IdContainer container;
		try {
			container = scs.create(sessionSite, sessionSecteur, sessionVoie);
			sessionSecteur.setId(container.getSecteurId());
			sessionSite.setId(container.getSiteId());
			sessionVoie.setId(container.getVoieId());
			vf.setId(container.getVoieId());
			return "result";
		} catch (NoSiteException | SecteurNotFoundException e) {
			logger.error("voieCreationFailed", e);
			return "result";
		}
	}

}
