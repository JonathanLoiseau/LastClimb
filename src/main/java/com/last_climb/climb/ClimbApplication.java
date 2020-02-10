package com.last_climb.climb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClimbApplication {
	static Logger logger = LoggerFactory.getLogger("Joze");

	public static void main(String[] args) {
		SpringApplication.run(ClimbApplication.class, args);
		logger.info("firstLog");

	}

}
