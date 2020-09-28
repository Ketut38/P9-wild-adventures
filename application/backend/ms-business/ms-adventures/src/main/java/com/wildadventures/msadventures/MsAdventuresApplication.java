package com.wildadventures.msadventures;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients("com.wildadventures.msadventures")
@EnableDiscoveryClient
public class MsAdventuresApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAdventuresApplication.class, args);
	}

	//Exportation des requétes vers zipkin
	@Bean
	Sampler getSample() {
		return Sampler.ALWAYS_SAMPLE;

	}

}
