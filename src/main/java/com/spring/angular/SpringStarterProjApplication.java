package com.spring.angular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages ="com.spring.angular")
public class SpringStarterProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStarterProjApplication.class, args);
	}

}
