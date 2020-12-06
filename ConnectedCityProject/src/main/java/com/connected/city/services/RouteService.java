package com.connected.city.services;

import org.springframework.stereotype.Service;

import com.connected.city.utility.RouteFinder;

/**
 * Search data map for requested connection.
 * */
@Service
public class RouteService implements IRouteService {
	
	

	/**
	 * Checks if there is a connection between provided starting point and end
	 * point.
	 * */
	public String checkConnection(final String startPoint,final String endPoint) {
		RouteFinder rf=new RouteFinder(startPoint,endPoint);
		if (rf.isConnected()) {
			System.out.println("Connection Found");
			return "Yes";
		} else {
			System.out.println("Connection Not Found");
			return "No";
		}
		
	}
	
}

