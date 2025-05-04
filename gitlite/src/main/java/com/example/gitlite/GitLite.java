package com.example.gitlite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.example.gitlite" })
@EntityScan(basePackages = { "com.example.gitlite" })
@SpringBootApplication
public class GitLite {

	public static void main(String[] args) {
		SpringApplication.run(GitLite.class, args);
	}

}
