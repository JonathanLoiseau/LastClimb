package com.last_climb.climb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.repo.SiteRepository;

@Controller
public class ApprovalController {

	@Autowired
	SiteRepository sRep;

	@GetMapping("/approval")
	public String approvalValidation() {
		return "index";

	}

	@PostMapping("/approval")
	public String approvalValidationPost(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		Site s = (Site) session.getAttribute("sitedisplay");
		s.setApproved(true);
		sRep.save(s);
		redirectAttributes.addAttribute("id", s.getId());
		return "redirect:/site_display";

	}

}
