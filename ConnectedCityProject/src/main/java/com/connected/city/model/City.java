package com.connected.city.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



import io.swagger.annotations.ApiModelProperty;

/**
 * Domain representing city node.
 * */

public class City implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* City name. */
	@ApiModelProperty(notes = "Name of the City")
	private String name;
	/*
	 * city status representing wither this node has been visited during the
	 * search or not.
	 */
	
	/* List of cities that are connected to this city. */
	@ApiModelProperty(notes = "List of connected Cites")
	private List<City> connections;

	/**
	 * Constructor
	 *
	 * @param name
	 *            city name.
	 * */
	public City(String name) {
		this.name = name;
		this.connections = new ArrayList<>();
	}

	/**
	 * Return city name.
	 *
	 * @return city name.
	 * */
	public String getName() {
		return this.name;
	}

	/**
	 * Adds a city to the list of connected cities.
	 *
	 * @param connection
	 *            city that this city is connected to.
	 * */
	public void addConnection(City city) {
		this.connections.add(city);
	}

	/**
	 * Return list of cities connected to this city.
	 *
	 * @return {@link List} of {@link City}s.
	 * */
	public List<City> getConnections() {
		return this.connections;
	}

	/**
	 * Check if the city node has connection with the target city.
	 *
	 * @param cityName
	 *            name of the city to check connection with.
	 * @return <code>true</code> if city is connected with target city,
	 *         <code>false</code> if not.
	 * */
	public boolean hasConnectionWith(City destination) {
		if (connections != null && !connections.isEmpty()) {
			return connections.contains(destination);
		}
		return false;
	}

	
	 public static City valueOf(final String cityName){
	    	return new City(cityName);
	 }

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31645535;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
    public String toString(){
		StringBuilder sb=new StringBuilder();
		sb.append("[ Orgion : "+name+"\r\n");
		if(connections!=null)connections.stream().forEach(city->{sb.append(" Destination:"+city.name+"\r\n");});
		sb.append("]\r\n");
		return sb.toString();
	}
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		City other = (City) obj;
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equalsIgnoreCase(other.name)) {
			return false;
		}
		return true;
	}

}
