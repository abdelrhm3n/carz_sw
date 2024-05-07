package com.carz.carz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class CarzApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarzApplication.class, args);
	}

}
