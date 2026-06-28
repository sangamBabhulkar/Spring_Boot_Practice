package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsProj2EurekaShoppingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProj2EurekaShoppingServiceApplication.class, args);
	}

}
