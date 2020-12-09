package com.connected.cities.utility;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.connected.cities.factory.City;
import com.connected.cities.factory.Graph;
import com.connected.cities.factory.GraphBuilder;
import com.connected.cities.factory.GraphBuilderFactory;

/**
 * Builds connections between cities.
 * */
public class RoutesBuilder {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public RoutesBuilder() {

	}
	public Graph<City> buildPath()throws Exception {
		try {
			GraphBuilder gb=GraphBuilderFactory.createGraphBuilder(GraphBuilderFactory.UNDIRECTED_GRAPH);
			Graph<City> g=gb.buildGraph();
			
			return g;
	    }catch(Exception ex) {
	    	//log.error(ex.getMessage(), ex); //No need to log exception here, we need to log at the starting point
	    	throw ex;
	    }
	}

}
