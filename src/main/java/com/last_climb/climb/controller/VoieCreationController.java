package com.last_climb.climb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.last_climb.climb.model.form.CreationVoieForm;
import com.last_climb.climb.model.form.VoiesForm;

@Controller
public class VoieCreationController {

	@GetMapping("/voie_creation")
	public String displayControllerVoiesCreation(Model model) {
		model.addAttribute("voiesform");
		return "voie_creation";

	}

	@PostMapping("/voie_creation")
	public String displayControllerVoiesCreationPost(CreationVoieForm crea, Model model, HttpSession session,
			VoiesForm vf) {

		model.addAttribute("voie", vf);
		session.setAttribute("voies", vf);

		return "result";
	}
}
