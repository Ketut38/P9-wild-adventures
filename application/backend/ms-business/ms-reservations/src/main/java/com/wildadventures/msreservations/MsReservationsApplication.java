package com.wildadventures.msreservations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.wildadventures.msreservations")
@EnableDiscoveryClient
public class MsReservationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsReservationsApplication.class, args);
	}

}
