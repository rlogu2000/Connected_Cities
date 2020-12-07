package com.connected.cities.search.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.connected.cities.model.City;
import com.connected.cities.model.Graph;
import com.connected.cities.model.Vertex;

public class DepthFirstSearchStrategy implements GraphSearchStrategy {
	

	private static final Logger log = LoggerFactory.getLogger(DepthFirstSearchStrategy.class);
	private final static ThreadLocal<Map<String,Boolean>> visited = new ThreadLocal<Map<String,Boolean>>(){
        @Override
        protected Map<String,Boolean> initialValue()
        {
        	log.info(" Thread Local initialized for Thread : "+Thread.currentThread().getName());
            return new HashMap<>();
        }
    };
    
    private String startPoint=null;
    private String endPoint=null;
    private boolean connectionFound=false;
    private Graph<City> cities=null;

	
	public DepthFirstSearchStrategy(String startPoint,
			                        String endPoint,
			                        Graph<City> cities){
		this.startPoint=startPoint;
		this.endPoint=endPoint;
		this.cities=cities;
		
	}
	public static Map<String,Boolean> getThreadLocalValue(){
	   	return visited.get();
	}
	public static ThreadLocal<Map<String,Boolean>> getThreadLocal(){
	   	return visited;
	}
	public boolean search() {
		DepthFirstSearchStrategy.getThreadLocal().remove();
		City city=City.valueOf(startPoint);	
					
		if(cities.getAdjVertices(city).isPresent())
			search(cities.getAdjVertices(city).get(),city);
		DepthFirstSearchStrategy.getThreadLocal().remove();
		return connectionFound;
	}
 	/**
	 * Recursive search to find the Route between 2 cities.
	 *
	 * @param currentNode
	 *            to check.
	 * */
	private void search(final List<Vertex<City>> connections,City currentCity){

		DepthFirstSearchStrategy.getThreadLocalValue().put(currentCity.getName(),true);
		
		if (currentCity.getName().equalsIgnoreCase(endPoint)) {
			connectionFound=true;
			log.info("*******Connection found in search**********");
			return;
		}
		connections.stream().forEach(nextCity->{
                                                if(DepthFirstSearchStrategy.getThreadLocalValue().get(nextCity.getObject().getName())==null && !connectionFound) {
                                                  log.info(" Next Hop to Search: "+nextCity.getObject().getName());
                                                  search(cities.getAdjVertices(nextCity.getObject()).get(),nextCity.getObject());
                                                }
                                                else {
                                                	log.info("Connection Found So returning");
                                                	return;
                                                }
                                            });
		log.info("End of Search");
		}
	
}
