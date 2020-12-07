package com.connected.cities.utility;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.connected.cities.factory.GraphBuilder;
import com.connected.cities.factory.GraphBuilderFactory;
import com.connected.cities.model.City;
import com.connected.cities.model.Graph;

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
			return gb.buildGraph();
	    }catch(Exception ex) {
	    	throw ex;
	    }
	}

}
