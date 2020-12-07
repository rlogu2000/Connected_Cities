package com.connected.cities.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GraphBuilderFactory {
	
	public static final String DIRECTED_GRAPH="directed";
	public static final String UNDIRECTED_GRAPH="undirected";
	public static final String DIRECTED_ACYLIC_GRAPH="directedaclyic";
	public static final String DIRECTED_WEIGHTED_GRAPH="directedweighted";
	
	private static  final Logger log = LoggerFactory.getLogger(GraphBuilderFactory.class);
	
	public static GraphBuilder createGraphBuilder (String type) {
		   log.info("Graph Type "+type);	
	       if (type.equalsIgnoreCase(DIRECTED_GRAPH)){
	              return new DirectedGraphBuilder();
	       }else if(type.equalsIgnoreCase(UNDIRECTED_GRAPH)){
	              return new UndirectedGraphBuilder();
	 	   }else if(type.equalsIgnoreCase(DIRECTED_ACYLIC_GRAPH)){
	 		  return new DirectedAcyclicGraphBuilder();
		   }else if(type.equalsIgnoreCase(DIRECTED_WEIGHTED_GRAPH)){
			  return new DirectedWeightedGraph();
		   }
	       return null;
	}
}
