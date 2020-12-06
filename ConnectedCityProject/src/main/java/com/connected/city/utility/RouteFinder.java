package com.connected.city.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.connected.city.model.City;

public class RouteFinder {
	
	private final ThreadLocal<Map<String,Boolean>> visited = new ThreadLocal<Map<String,Boolean>>(){
        @Override
        protected Map<String,Boolean> initialValue()
        {
            return new HashMap<>();
        }
    };
    
    private String startPoint=null;
    private String endPoint=null;
    private boolean connectionFound=false;
    private List<City> cities=null;
    
    public RouteFinder(final String startPoint,final String endPoint) {
    	this.startPoint=startPoint;
    	this.endPoint=endPoint;
    }
    /**
	 * @return false if there is no connection between provided cities.
	 * */
	public boolean isConnected() {
		
		visited.remove();
		cities=CityFactory.INSTANCE.getCities();
		Optional<City> orgion=CityUtility.getCity(cities,startPoint);
		if(orgion.isPresent())
			dfs(orgion.get());
		return connectionFound;
	}

	
	/**
	 * Used to search for connection.
	 *
	 * @param currentNode
	 *            to check.
	 * */
	protected void dfs(final City currentOrgionCity){
		
		//System.out.println("Current Thread : "+Thread.currentThread().getName());
	    visited.get().put(currentOrgionCity.getName(),true);

		System.out.println(" Current Node :"+currentOrgionCity.getName());
		if (currentOrgionCity.getName().equalsIgnoreCase(endPoint)) {
			connectionFound=true;
			System.out.println("*******Connection found in search**********");
			return;
		}
		Optional<City> orgionCity=CityUtility.getCity(cities,currentOrgionCity.getName());
		//System.out.println(" Current Node2 :"+orgionCity.get().getName());
		
		//System.out.println(" Current Node Connections "+orgionCity.get().getConnections());
		orgionCity.get().getConnections().stream().forEach(nextHop->{
																	System.out.println(" Next Hop "+nextHop.getName());
			                                                        if(visited.get().get(nextHop.getName())==null && !connectionFound) {
			                                                          System.out.println(" Next Hop to Search: "+nextHop.getName());
			                                                          dfs(nextHop);
			                                                        }
			                                                        else {
			                                                        	System.out.println("Connection Found So returning");
			                                                        	return;
			                                                        }
			                                                    });
			System.out.println("End of Search");

		}

}
