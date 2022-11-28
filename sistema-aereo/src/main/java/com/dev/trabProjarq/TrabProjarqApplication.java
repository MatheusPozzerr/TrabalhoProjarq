package com.dev.trabProjarq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TrabProjarqApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabProjarqApplication.class, args);
	}

}
 