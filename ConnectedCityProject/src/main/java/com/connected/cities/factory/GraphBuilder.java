package com.connected.cities.factory;

import com.connected.cities.model.City;
import com.connected.cities.model.Graph;

public abstract class GraphBuilder {
	
	public abstract Graph<City> buildGraph()throws Exception;
}
