package com.veynice.rest.quotesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class QuotesserviceApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(appClass, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(appClass);
	}

	private static Class<QuotesserviceApplication> appClass = QuotesserviceApplication.class;
}
