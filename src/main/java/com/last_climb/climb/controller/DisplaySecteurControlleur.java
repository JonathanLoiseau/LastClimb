package com.last_climb.climb.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.last_climb.climb.model.entity.Secteur;
import com.last_climb.climb.repo.SecteurRepository;

@Controller
public class DisplaySecteurControlleur {

	@Autowired
	private SecteurRepository sRep;

	@GetMapping("/secteur_display")
	private String DisplaySecteur(Model model, HttpSession session, @RequestParam("name") String name) {

		Optional<Secteur> s = sRep.findByName(name);
		model.addAttribute("displaysecteur", s.get());
		session.setAttribute("displaysecteur", s.get());
		return "secteur_display";
	}

	@PostMapping("/secteur_display")
	private String DisplaySecteurPost(Model model, HttpSession session, @RequestParam("name") String name) {
		Optional<Secteur> s = sRep.findByName(name);
		model.addAttribute("displaysecteur", s.get());
		session.setAttribute("displaysecteur", s.get());
		return "secteur_display";
	}

}
