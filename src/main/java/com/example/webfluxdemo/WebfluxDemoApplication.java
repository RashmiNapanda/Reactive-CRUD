package com.example.webfluxdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan
public class WebfluxDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebfluxDemoApplication.class, args);
	}
}
