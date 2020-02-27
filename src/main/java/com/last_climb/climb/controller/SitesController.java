package com.last_climb.climb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.model.form.CommentForm;
import com.last_climb.climb.model.form.FindSiteForm;
import com.last_climb.climb.repo.SiteRepository;
import com.last_climb.climb.services.CommentService;
import com.last_climb.climb.services.FindSiteService;

@Controller
public class SitesController {

	private static final Logger logger = LoggerFactory.getLogger(SitesController.class);
	@Autowired
	private FindSiteService fss;
	@Autowired
	private SiteRepository sRep;
	@Autowired
	private CommentService cs;

	@GetMapping("/sites")
	public String displaySites(Model model, HttpSession session) {

		model.addAttribute("findform", new FindSiteForm());
		return "sites";

	}

	@PostMapping("/sites")
	public String displaySitesPost(Model model, HttpSession session) {

		model.addAttribute("findform", new FindSiteForm());
		return "sites";

	}

	@GetMapping("/find_site")
	public String displaySiteFind(Model model, HttpSession session) {
		model.addAttribute("findform", new FindSiteForm());
		session.setAttribute("FindSite", new FindSiteForm());

		return "find_site";
	}

	@PostMapping("/find_site")
	public String displaySiteFind(Model model, HttpSession session, FindSiteForm fs) {
		session.setAttribute("FindSite", fs);
		model.addAttribute("findform", new FindSiteForm());
		List<Site> siteList = (ArrayList<Site>) fss.findSite(fs);
		session.setAttribute("listsite", siteList);
		model.addAttribute("ListSite", siteList);
		for (Site s : siteList) {
			logger.debug(s.getName());
		}
		return "site_result";
	}

	@GetMapping("/site_result")
	public String displaySiteResult(Model model, @RequestParam("id") String id, HttpSession session) {
		return "site_result";
	}

	@PostMapping("/site_result")
	public String displaySiteResultPost(Model model, @RequestParam("id") Long id, HttpSession session) {
		return "site_display";
	}

	@GetMapping("/site_display")
	public String displaySiteDisplay(@RequestParam("id") Long id, Model model, HttpSession session) {

		Optional<Site> site = sRep.findById(id);
		model.addAttribute("sitedisplay", site.get());
		session.setAttribute("sitedisplay", site.get());
		model.addAttribute("commentForm", new CommentForm());
		session.setAttribute("commentform", new CommentForm());

		return "site_display";
	}

	@Transactional
	@PostMapping("/site_display")
	public String displaySiteDisplayPost(Model model, HttpSession session, CommentForm cf) {
		;
		Utilisateur user = (Utilisateur) session.getAttribute("currentUser");
		cf.setUserName(user.getUsername());
		Site s = (Site) session.getAttribute("sitedisplay");
		model.addAttribute("sitedisplay", s);
		session.setAttribute("sitedisplay", s);
		cs.comment(s, cf);

		return "site_display";

	}

}
