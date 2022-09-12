package com.sj.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
// 1. Annotations
@RestController
public class HelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}
	
	
//	1. Annotation
	@RequestMapping("/")
//	 3. Method that maps to the request route above
	public String hello() {
		return "Hello World!";
	}

//	1. Annotation
	@RequestMapping("/greeting")
//	 3. Method that maps to the request route above
	public String greeting() {
		return "Hello, my name is Sukanya! Nice to meet you!";
	}

//	1. Annotation
	@RequestMapping("/goodbye")
//	 3. Method that maps to the request route above
	public String goodbye() {
		return "Goodbye!";
	}
	
//	1. Annotation
	@RequestMapping("/hungry")
//	 3. Method that maps to the request route above
	public String hungry() {
		return "I'm hungry.";
	}
	
	
	
	
	
	
	
	
	




}
