package com.connected.cities.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Vertex<T> {
	
	private T object;
	public Vertex(T object){
		this.object=object;
	}
	
	public String toString() {
		return object.toString();
	}
}
