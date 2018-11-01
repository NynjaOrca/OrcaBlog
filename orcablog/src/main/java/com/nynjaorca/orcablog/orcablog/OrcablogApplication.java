package com.nynjaorca.orcablog.orcablog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.nynjaorca.orcablog.orcablog.repositories")
@EntityScan("com.nynjaorca.orcablog.orcablog.entities")
@SpringBootApplication
public class OrcablogApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrcablogApplication.class, args);
	}
}
