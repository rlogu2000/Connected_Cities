package com.connected.cities.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.connected.cities.utility.CityGraphSingleton;



@SpringBootApplication
@ComponentScan(basePackages={"com.connected.cities"})
public class ConnectedCitiesApplication {  
	private  final Logger log = LoggerFactory.getLogger(this.getClass());
	public static void main(String[] args) {
		SpringApplication.run(ConnectedCitiesApplication.class, args);
    } 
	@Bean
	public CommandLineRunner loadCities() {
		return (args) -> {
			CityGraphSingleton.getInstance();
		};
	}
	
}  