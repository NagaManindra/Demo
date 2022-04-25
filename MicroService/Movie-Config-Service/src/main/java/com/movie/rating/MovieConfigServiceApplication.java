package com.movie.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MovieConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieConfigServiceApplication.class, args);
	}

}
