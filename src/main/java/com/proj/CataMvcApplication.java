package com.proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CataMvcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CataMvcApplication.class, args);
		
	}

}
