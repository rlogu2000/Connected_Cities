package com.connected.city.utility;

import java.util.List;
import java.util.Optional;

import com.connected.city.model.City;

public class CityUtility {
	
	/**
	 * Checks if inserted cities are the same.
	 * @param cityA starting point.
	 * @param cityB end point.
	 * */
	public static boolean checkBothSameCity(final String cityA,final String cityB){
		if(cityA.trim().toLowerCase().equals(cityB.trim().toLowerCase())){
			return true;
		}
		return false;
	}
	
	 protected static Optional<City> getCity(final List<City> cities,final String cityName){
			City city=City.valueOf(cityName);	
			if(cities.contains(city))
				return Optional.of(cities.get(cities.indexOf(city)));
			else 
				return Optional.ofNullable(null);
	}
	public boolean containsCity(final List<City> cities,final String cityName) {
	        return cities.stream().anyMatch(o -> o.getName().equals(cityName));
		    	
	}

}
