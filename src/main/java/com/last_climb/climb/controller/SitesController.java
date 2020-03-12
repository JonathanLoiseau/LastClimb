package com.last_climb.climb.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.model.exception.NoCommentaryException;
import com.last_climb.climb.model.exception.NoSiteException;
import com.last_climb.climb.model.form.CommentForm;
import com.last_climb.climb.model.form.FindSiteForm;
import com.last_climb.climb.services.CheckOptionalGetObjectService;
import com.last_climb.climb.services.CommentService;
import com.last_climb.climb.services.FindSiteService;

@Controller
public class SitesController {

	private static final Logger logger = LoggerFactory.getLogger(SitesController.class);
	@Autowired
	private FindSiteService findSiteService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private CheckOptionalGetObjectService checkAndGet;

	@GetMapping("/site")
	public String displaySites(Model model, HttpSession session) {
		model.addAttribute("findform", new FindSiteForm());
		return "site";

	}

	@PostMapping("/site")
	public String displaySitesPost(Model model, HttpSession session) {
		model.addAttribute("findform", new FindSiteForm());
		return "site";
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
		List<Site> siteList = (ArrayList<Site>) findSiteService.findSite(fs);
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

		try {
			Site site = checkAndGet.findANdCheckSiteById(id);
			model.addAttribute("sitedisplay", site);
			session.setAttribute("sitedisplay", site);
			model.addAttribute("commentForm", new CommentForm());
			session.setAttribute("commentform", new CommentForm());
		} catch (NoSiteException e) {
			logger.error("pas de site", e);
		}
		return "site_display";
	}

	@Transactional
	@PostMapping("/comment")
	public String displayComment(Model model, HttpSession session, CommentForm cf,
			RedirectAttributes redirectAttributes) throws IOException {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		cf.setUserName(username);
		Site s = (Site) session.getAttribute("sitedisplay");
		model.addAttribute("sitedisplay", s);
		commentService.comment(s, cf);
		redirectAttributes.addAttribute("id", s.getId());
		return "redirect:/site_display";
	}

	@PostMapping("/deletecom")
	public String deleteComm(@RequestParam("id") Long id, RedirectAttributes redirectAttributes, HttpSession session) {
		try {
			commentService.delete(id);
		} catch (NoCommentaryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Site s = (Site) session.getAttribute("sitedisplay");
		redirectAttributes.addAttribute("id", s.getId());
		return "redirect:/site_display";
	}

	@Transactional
	@PostMapping("/editcom")
	public String editComm(@RequestParam("id") Long id, RedirectAttributes redirectAttributes, HttpSession session,
			Model model, CommentForm cf) {

		try {
			System.out.println("editcom");
			commentService.edit(id, cf.getCommentaire());
		} catch (NoCommentaryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Site s = (Site) session.getAttribute("sitedisplay");
		redirectAttributes.addAttribute("id", s.getId());
		return "redirect:/site_display";
	}

}
