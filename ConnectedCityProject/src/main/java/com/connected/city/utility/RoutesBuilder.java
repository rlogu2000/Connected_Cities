package com.connected.city.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.connected.city.model.City;
import com.connected.city.model.Connection;

/**
 * Builds connections between cities.
 * */
public class RoutesBuilder {
	private static final String DELIMITER = ",";
	
	private BufferedReader bReader;

	public RoutesBuilder(final BufferedReader bReader) {
		this.bReader = bReader;

	}
	public List<City> buildConnections() {

		List<City> cities=new ArrayList<>();
		String line;
		try {
			while ((line = bReader.readLine()) != null) {
				String edges[] = getEdges(line);
				addConnection(cities,new Connection(edges[0].trim(),edges[1].trim()));
			}
		} catch (IOException e) {
			Terminator.terminate(e.getMessage(), 1);
		}
		catch (Exception e) {
			Terminator.terminate(e.getMessage(), 1);
		}
		printGraph(cities);
		return cities;
	}
	private void printGraph(List<City> cities){

		cities.stream().forEach(city->{
			                            System.out.println("Orgin City : "+city.getName());
			                            city.getConnections().stream().forEach(destCity->{
											                                               System.out.println("\t\tConnection with Destination: "+destCity.getName());
											                                             });
											                                             });
	}
	protected void addConnection(List<City> cities,Connection connection){
		
		Optional<City> orgionCity=CityUtility.getCity(cities,connection.getOrigin());
		Optional<City> destinationCity=CityUtility.getCity(cities,connection.getDestination());
		buildRoute(cities,orgionCity,destinationCity,connection.getOrigin(),connection.getDestination());
		buildRoute(cities,destinationCity,orgionCity,connection.getDestination(),connection.getOrigin());

		/*if(orgionCity.isPresent()){
			
			if(destinationCity.isPresent()){
				if(!orgionCity.get().hasConnectionWith(destinationCity.get()))
					orgionCity.get().addConnection(destinationCity.get());
			}
			else
			  orgionCity.get().addConnection(City.valueOf(connection.getDestination()));
		}
		else
		{
			City cityA=City.valueOf(connection.getOrigin());
			if(destinationCity.isPresent())
				cityA.addConnection(destinationCity.get());
			else
				cityA.addConnection(City.valueOf(connection.getDestination()));
			cities.add(cityA);
		}
        if(destinationCity.isPresent()){
        	if(orgionCity.isPresent()) {
				if(!destinationCity.get().hasConnectionWith(orgionCity.get()))
					destinationCity.get().addConnection(orgionCity.get());
	        	}
        	else
        		destinationCity.get().addConnection(City.valueOf(connection.getOrigin()));
			
		}
		else
		{
			City cityB=City.valueOf(connection.getDestination());
			if(orgionCity.isPresent())
				cityB.addConnection(orgionCity.get());
			else
				cityB.addConnection(City.valueOf(connection.getOrigin()));
			cities.add(cityB);
		}*/
	 }
	
	protected void buildRoute(List<City> cities,Optional<City> from,Optional<City> to,String fromCityName,String toCityName) {
		if(from.isPresent()){
			if(to.isPresent()){
				if(!from.get().hasConnectionWith(to.get()))
					from.get().addConnection(to.get());
			}
			else
				from.get().addConnection(City.valueOf(toCityName));
		}
		else
		{
			City city=City.valueOf(fromCityName);
			if(to.isPresent())
				city.addConnection(to.get());
			else
				city.addConnection(City.valueOf(toCityName));
			cities.add(city);
		}
	}
	
	protected String[] getEdges(final String line)throws Exception {
		String[] cities=line.trim().toLowerCase().replace(DELIMITER + " ",DELIMITER).split(DELIMITER);
		if(cities.length!=2)
			throw new Exception("File Content is not Correct");
		else
			return cities;
		
		
	}


}
