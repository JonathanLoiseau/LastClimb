package com.last_climb.climb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.model.form.FindSiteForm;
import com.last_climb.climb.repo.SiteRepository;
import com.last_climb.climb.services.FindSiteService;

@Controller
public class SitesController {

	private static final Logger logger = LoggerFactory.getLogger(SitesController.class);
	@Autowired
	private FindSiteService fss;
	@Autowired
	private SiteRepository sRep;

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
	public String displaySiteResult(Model model, @RequestParam("name") String name, HttpSession session) {
		return "site_result";
	}

	@PostMapping("/site_result")
	public String displaySiteResultPost(Model model, @RequestParam("name") String name, HttpSession session) {
		return "site_display";
	}

	@GetMapping("/site_display")
	public String displaySiteDisplay(@RequestParam("name") String name, Model model, HttpSession session) {

		Optional<Site> site = sRep.findByName(name);
		model.addAttribute("sitedisplay", site.get());
		session.setAttribute("sitedisplay", site.get());

		return "site_display";
	}

}
