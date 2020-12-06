package com.connected.city.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.connected.city.model.City;

public enum CityFactory implements Serializable {
    
    INSTANCE; 
 
	private static final long serialVersionUID = 1L;	
    private final List<City> cities=new LinkedList<>();
 
     
    private CityFactory() {
    	System.out.println("Singleton Insance Created");
    	loadCities();
        
    }
    public static CityFactory  getInstance() {
    	return INSTANCE;
    }
    private void loadCities() {
    	try {
       		File routes = new ClassPathResource("cities.txt").getFile();
    		System.out.println("Resource file "+routes);
	    	FileLoader fileLoader = new FileLoader();
			BufferedReader fileBufferReader = fileLoader.loadFile(routes);
			RoutesBuilder connectionBuilder = new RoutesBuilder(fileBufferReader);
			this.cities.addAll(connectionBuilder.buildConnections());
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }
    protected Object readResolve() {
        return getInstance();
    }

    public List<City> getCities(){
    	//printGraph(this.cities);
    	return this.cities;
    }
    /*private void printGraph(List<City> cities){

		cities.stream().forEach(city->{
			                            System.out.println("Orgin City1 : "+city.getName());
			                            city.getConnections().stream().forEach(destCity->{
											                                               System.out.println("\t\tConnection with Destination1: "+destCity.getName());
											                                             });
											                                             });
	}*/
    
    
}