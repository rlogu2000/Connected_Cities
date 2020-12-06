package com.connected.city.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Connection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String origin;
	private String destination;
	
	public Connection(String origin,String destination) {
		this.origin=origin;
		this.destination=destination;
	}
	
}
