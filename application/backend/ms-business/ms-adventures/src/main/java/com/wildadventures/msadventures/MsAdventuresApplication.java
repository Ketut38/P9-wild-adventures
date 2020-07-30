package com.wildadventures.msadventures;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.wildadventures.msadventures")
public class MsAdventuresApplication {

	public static void main(String[] args) {

		SpringApplication.run(MsAdventuresApplication.class, args);
	}

}
