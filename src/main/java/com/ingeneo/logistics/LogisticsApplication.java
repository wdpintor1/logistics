package com.ingeneo.logistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class LogisticsApplication {

	public static void main(String[] args) {
		System.out.println("¡Hola Ingeneo!");
		SpringApplication.run(LogisticsApplication.class, args);
	}

}
