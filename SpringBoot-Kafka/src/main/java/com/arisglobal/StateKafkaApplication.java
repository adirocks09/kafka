package com.arisglobal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
//@ComponentScan(basePackages = { "com.arisglobal"} )
public class StateKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StateKafkaApplication.class, args);
	}

}
