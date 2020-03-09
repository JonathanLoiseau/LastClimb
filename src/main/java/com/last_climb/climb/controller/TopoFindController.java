package com.last_climb.climb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.last_climb.climb.model.entity.Topo;
import com.last_climb.climb.model.entity.Utilisateur;
import com.last_climb.climb.repo.TopoRepository;
import com.last_climb.climb.services.PrincipalToUserService;
import com.last_climb.climb.services.TopoBookingService;

@Controller
public class TopoFindController {
	@Autowired
	private TopoBookingService topoBooking;

	@Autowired
	private TopoRepository tRep;

	@Autowired
	private PrincipalToUserService principal;

	@GetMapping("/topo_find")

	public String topoFindDisplay(Model model, HttpSession session) {
		model.addAttribute("topoSearch", new Topo());
		session.setAttribute("topoSearch", new Topo());

		return "topo_find";
	}

	@Transactional
	@PostMapping("/topo_find")
	public String topoFindDisplayPost(Model model, HttpSession session, Topo topo) {
		session.setAttribute("topoSearch", topo);
		List<Topo> topoList = tRep.findByLieux(topo.getLieux());
		model.addAttribute("topolist", topoList);
		for (Topo t : topoList) {
			System.out.println(t.getName());
		}

		return "select_topo";
	}

	@Transactional
	@PostMapping("/topobooking")
	public String bookTopo(@RequestParam Long iD) {
		Utilisateur user = principal.principalToDbUser();
		topoBooking.bookTopo(iD, user.getId());
		return "TopoSave";
	}

//	@Transactional
//	@GetMapping("/topobooking/{iD}")
//	public String bookTopoGet(@PathVariable Long iD) {
//		topoBooking.bookTopo(iD);
//
//		return "index";
//	}
}
