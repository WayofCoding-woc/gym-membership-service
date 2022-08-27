package com.woc.gms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.woc.gms", "org.m3"})
@SpringBootApplication
public class GymMembershipServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymMembershipServiceApplication.class, args);
	}

}
