package com.example.emailapp.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmailApplication.class, args);
		System.out.println("Hello world");
	}

}

WorkDir -> Staging -> Commit -> push