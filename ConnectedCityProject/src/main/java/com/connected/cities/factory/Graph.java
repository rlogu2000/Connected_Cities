package com.connected.cities.factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import lombok.ToString;
@ToString
public class Graph<T> {
	
	private Map<Vertex<T>, List<Vertex<T>>> adjVertices=new ConcurrentHashMap<>();
	
		protected void addVertex(T object) {
	    adjVertices.putIfAbsent(new Vertex<T>(object), new ArrayList<>());
	}

	protected void removeVertex(T object) {
	    Vertex<T> v = new Vertex<T>(object);
	    adjVertices.values().stream().forEach(e -> e.remove(v));
	    adjVertices.remove(new Vertex<T>(object));
	}
	protected void addEdge(T object1, T object2) {
	    Vertex<T> v1 = new Vertex<T>(object1);
	    Vertex<T> v2 = new Vertex<T>(object2);
	    if(!adjVertices.get(v1).contains(v2))
	    	adjVertices.get(v1).add(v2);
	    if(!adjVertices.get(v2).contains(v1))
	    	adjVertices.get(v2).add(v1);
	}
	protected void removeEdge(T object1, T object2) {
	    Vertex<T> v1 = new Vertex<T>(object1);
	    Vertex<T> v2 = new Vertex<T>(object2);
	    List<Vertex<T>> eV1 = adjVertices.get(v1);
	    List<Vertex<T>> eV2 = adjVertices.get(v2);
	    if (eV1 != null)
	        eV1.remove(v2);
	    if (eV2 != null)
	        eV2.remove(v1);
	}
	public Optional<List<Vertex<T>>> getAdjVertices(T object) {
	    return Optional.ofNullable(Collections.unmodifiableList(adjVertices.get(new Vertex<T>(object))));
	}
	public Map<Vertex<T>, List<Vertex<T>>> getAdjVertices() {
	    return Collections.unmodifiableMap(adjVertices);
	}
	public Vertex<T> createVertex(T label) {
	    return new Vertex<T>(label);
	}
	
	
}
