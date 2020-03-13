package com.last_climb.climb.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

	Resource loadAsResource(String filename);

	void store(MultipartFile multipass, String name);

}
