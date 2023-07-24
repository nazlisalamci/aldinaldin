package com.repo.aldinaldin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@CrossOrigin(origins = "*")
public class AldinaldinApplication {

	public static void main(String[] args) {
		SpringApplication.run(AldinaldinApplication.class, args);
	}

}
