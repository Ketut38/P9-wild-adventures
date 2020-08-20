package com.wildadventures.mssession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.wildadventures.mssession")
public class MsSessionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSessionApplication.class, args);
	}

}
