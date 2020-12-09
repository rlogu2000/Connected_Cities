package com.connected.cities.factory;

import java.io.IOException;

public abstract class GraphBuilder {
	
	public abstract Graph<City> buildGraph()throws IOException,InvalidFileException,Exception;
	public abstract Graph<City> buildGraph(String file) throws IOException,InvalidFileException,Exception;
}
