package com.client.rasplus.message.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class RasplusMessageApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RasplusMessageApiApplication.class, args);
	}

}
