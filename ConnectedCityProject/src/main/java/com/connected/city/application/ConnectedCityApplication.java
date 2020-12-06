package com.connected.city.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.connected.city.utility.CityFactory;



@SpringBootApplication
@ComponentScan(basePackages={"com.connected.city"})
public class ConnectedCityApplication {  
	private static final Logger log = LoggerFactory.getLogger(ConnectedCityApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ConnectedCityApplication.class, args);
    } 
	@Bean
	public CommandLineRunner loadCities() {
		return (args) -> {
			CityFactory.getInstance();
		};
	}
	
}  