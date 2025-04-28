package com.apiMongo.tadb4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tadb4Application {

	public static void main(String[] args) {
		System.out.println("URI: " + System.getenv("MONGODB_URI"));
		SpringApplication.run(Tadb4Application.class, args);
	}

}
