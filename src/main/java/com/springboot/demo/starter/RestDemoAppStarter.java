package com.springboot.demo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.springboot.demo.user.service")
@EnableAutoConfiguration
public class RestDemoAppStarter extends SpringBootServletInitializer {
	
	public static void main(String args[]) {
		SpringApplication.run(RestDemoAppStarter.class, args);
	}

}
