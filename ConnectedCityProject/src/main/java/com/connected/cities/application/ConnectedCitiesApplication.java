package com.connected.cities.application;


import static com.connected.cities.utility.CityGraphSingleton.getInstance;

import org.springframework.boot.CommandLineRunner;

import static org.springframework.boot.SpringApplication.run;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author LOGANATHAN
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.connected.cities" })
public class ConnectedCitiesApplication {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
		run(ConnectedCitiesApplication.class, args);
	}
  
    /**
     *
     * @return
     */
    @Bean
	public CommandLineRunner loadCities() {
		return (args) -> {
			getInstance();
		};
	}

}