package com.last_climb.climb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.last_climb.climb.model.form.CreationVoieForm;
import com.last_climb.climb.model.form.VoiesForm;

@Controller
public class SecteurCreationController {

	@GetMapping("/secteur_creation")
	public String displayControllerVoiesCreation(Model model, HttpSession session) {
//		model.addAttribute("voiesform");
		model.addAttribute("creationvoieform", new CreationVoieForm());
		System.out.println("dans le get de secteur création");

		return "secteur_creation";

	}

	@PostMapping("/secteur_creation")
	public String displayControllerVoiesCreationPost(CreationVoieForm crea, Model model, HttpSession session) {
		model.addAttribute("voiesform", crea);
		model.addAttribute("voie", new VoiesForm());

		session.setAttribute("secteur", crea);

		System.out.println("dans le post de secteur création");

		return "voie_creation";
	}
}
