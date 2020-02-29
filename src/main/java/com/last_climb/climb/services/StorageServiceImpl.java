package com.last_climb.climb.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StorageServiceImpl implements StorageService {
	 
	private static final String PATH_ROOT= "images/sites";
	
	@Override
	public Resource loadAsResource(String filename) {
		try {
			
			//On pointe sur le fichier image filename dans le repertoire PATH_ROOT
			Path file = Paths.get(PATH_ROOT).resolve(filename);
			
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}
			else {
				throw new IllegalStateException(
						"Could not read file: " + filename);

			}
		}
		catch (MalformedURLException e) {
			throw new IllegalStateException("Could not read file: " + filename, e);
		}
	}

	@Override
	public void store(MultipartFile multipass) {
		
		String filename = StringUtils.cleanPath(multipass.getOriginalFilename());
		try {
			if (multipass.isEmpty()) {
				throw new IllegalStateException("Failed to store empty file " + filename);
			}
			if (filename.contains("..")) {
				// This is a security check
				throw new IllegalStateException(
						"Cannot store file with relative path outside current directory "
								+ filename);
			}
			//prends le stream et le copy
			try (InputStream inputStream = multipass.getInputStream()) {
				Path file = Paths.get(PATH_ROOT).resolve(filename);
				Files.copy(inputStream, file, StandardCopyOption.REPLACE_EXISTING);
			}
		}
		catch (IOException e) {
			throw new IllegalStateException("Failed to store file " + filename, e);
		}
	
	}

}
