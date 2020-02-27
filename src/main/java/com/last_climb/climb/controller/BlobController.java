package com.last_climb.climb.controller;

import java.awt.Image;
import java.util.Optional;

import javax.swing.ImageIcon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.last_climb.climb.model.entity.Site;
import com.last_climb.climb.repo.SiteRepository;

@Controller
public class BlobController {

	@Autowired
	private SiteRepository sRep;

	@ResponseBody
	@GetMapping(value = "/displayblob")
	private ResponseEntity<byte[]> gimmeblob(Model model, @RequestParam("id") Long id) {
		Optional<Site> a = sRep.findById(id);
		Site s = a.get();
		byte[] displayImg = s.getSiteimg();
		HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(displayImg, headers, HttpStatus.OK);
		return responseEntity;
	}

	@ResponseBody
	@PostMapping(value = "/displayblob")
	private Image gimmeblobPost(Model model, @RequestParam("id") Long id) {
		Optional<Site> a = sRep.findById(id);
		Site s = a.get();
		byte[] displayImg = s.getSiteimg();
		ImageIcon imageIcon = new ImageIcon(displayImg);
		return imageIcon.getImage();

	}

}
