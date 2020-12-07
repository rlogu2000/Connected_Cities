package com.connected.cities.utility;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.connected.cities.search.strategy.GraphSearchStrategy;


public class RouteFinder {
	
	private static final Logger log = LoggerFactory.getLogger(RouteFinder.class);
    
    /**
	 * @return false if there is no connection between to cities.
	 * */
	
	public boolean isConnected(GraphSearchStrategy gss) {
		return gss.search();
		
	}
}
