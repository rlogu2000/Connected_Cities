package com.connected.cities.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.connected.cities.search.strategy.DepthFirstSearchStrategy;
import com.connected.cities.search.strategy.GraphSearchStrategy;
import com.connected.cities.utility.CityGraphSingleton;
import com.connected.cities.utility.RouteFinder;

/**
 * Search data map for requested connection.
 * */
@Service
public class RouteService implements IRouteService {
	
	private  final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * Checks if there is a connection between provided starting point and end
	 * point.
	 * */
	public String findConnection(final String startPoint,final String endPoint) {
		RouteFinder rf=new RouteFinder();
		GraphSearchStrategy gss=new DepthFirstSearchStrategy(startPoint,endPoint,CityGraphSingleton.getInstance().getCities());
		if (rf.isConnected(gss)) {
			log.info("Connection Found");
			return "Yes";
		} else {
			log.info("Connection Not Found");
			return "No";
		}
		
	}
	
}

