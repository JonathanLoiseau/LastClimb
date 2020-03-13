package com.last_climb.climb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.last_climb.climb.services.StorageService;

@Controller
public class UploadController {

	@Autowired
	private StorageService ss;

	// fonction de récupération de l'image

	@GetMapping("/images/{filename}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = ss.loadAsResource(filename);
//			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
//					"attachment; filename=\"" + file.getFilename() + "\"").body(file);

		return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/png").body(file);
	}

//	@PostMapping("/images")
//	public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes,
//			SiteForm sform) {
//
//		ss.store(file, sform.getName());
//		redirectAttributes.addFlashAttribute("message",
//				"You successfully uploaded " + file.getOriginalFilename() + "!");
//		redirectAttributes.addFlashAttribute("filename", file.getOriginalFilename());
//
//		return "redirect:/";
//	}

}
