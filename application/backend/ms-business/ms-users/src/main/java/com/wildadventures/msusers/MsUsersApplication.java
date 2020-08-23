package com.wildadventures.msusers;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableFeignClients("com.wildadvenures.msusers")
@EnableDiscoveryClient
public class MsUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsUsersApplication.class, args);
	}

	//Exportation des requétes vers zipkin
	@Bean
	Sampler getSample() {
		return Sampler.ALWAYS_SAMPLE;

	}
}
