package com.delinkcious.linkservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LinkServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkServiceApplication.class, args);
	}

}
