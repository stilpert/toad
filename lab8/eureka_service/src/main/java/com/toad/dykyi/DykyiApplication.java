package com.toad.dykyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DykyiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DykyiApplication.class, args);
	}

}
