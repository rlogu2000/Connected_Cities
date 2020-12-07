package com.connected.cities.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Domain Object representing city node in the Graph structure.
 * */
@EqualsAndHashCode
@Getter
@Setter
public class City implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* City name. */
	@ApiModelProperty(notes = "Name of the City")
	private String name;
	
	/**
	 * Constructor
	 *
	 * @param name
	 *            city name.
	 * */
	public City(String name) {
		this.name = name;
		
	}
    public static City valueOf(final String cityName){
	    	return new City(cityName);
	 }

	@Override
    public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("[ Name : "+name+"]\r\n");
		return sb.toString();
	}
}
