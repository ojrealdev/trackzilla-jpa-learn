package com.keysoft.bucktrackerjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.keysoft")
public class BucktrackerJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BucktrackerJpaApplication.class, args);
	}
}
