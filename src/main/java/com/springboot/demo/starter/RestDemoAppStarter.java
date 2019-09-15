package com.springboot.demo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = "com.springboot.demo.user.service")
@EnableAutoConfiguration
@EnableCaching
public class RestDemoAppStarter extends SpringBootServletInitializer {
	
	public static void main(String args[]) {
		SpringApplication.run(RestDemoAppStarter.class, args);
	}

}
