package com.pharmaplus.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class PharmaplusArticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmaplusArticleApplication.class, args);
	}

}
