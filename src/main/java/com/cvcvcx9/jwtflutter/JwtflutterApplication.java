package com.cvcvcx9.jwtflutter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JwtflutterApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtflutterApplication.class, args);
	}

}
