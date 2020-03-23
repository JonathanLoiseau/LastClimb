package com.last_climb.climb.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImgNameCreationImpl implements ImgNameCreationService {

	@Override
	public String changeName(String fileName,MultipartFile multipartfile) {
		String pattern = "dd_MM_yyyy_hh_mm_ss a";
		LocalDateTime nowTime = LocalDateTime.now();
		String date = nowTime.format(DateTimeFormatter.ofPattern(pattern));
		String filename = "";
		filename += date;
		filename += filename;
		filename+= StringUtils.cleanPath(multipartfile.getOriginalFilename());
		return filename;
	}

}
