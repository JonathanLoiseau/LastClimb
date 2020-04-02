package com.last_climb.climb.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImgNameCreationService {
	String changeName(String userId,MultipartFile multipartFile);
}
