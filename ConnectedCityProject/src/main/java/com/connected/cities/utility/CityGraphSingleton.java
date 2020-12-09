package com.connected.cities.utility;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.connected.cities.factory.City;
import com.connected.cities.factory.Graph;

public enum CityGraphSingleton {
    
    INSTANCE; 
    
    private  final Logger log = LoggerFactory.getLogger(this.getClass());
 
    private Graph<City> graph=null; 
    private CityGraphSingleton() {
    	log.info("Singleton Insance Created");
    	createRoutes();
        
    }
    public static CityGraphSingleton  getInstance() {
    	return INSTANCE;
    }
    private void createRoutes() {
    	try {
			RoutesBuilder rb = new RoutesBuilder();
			this.graph=rb.buildPath();
			log.info("***The final Graph ***"+graph);
    	}catch(Exception ex) {
	    	log.error(ex.getMessage(), ex); 
    		Terminator.terminate(ex.getMessage(), 1);
    		ex.printStackTrace();
    	}
    }
    protected Object readResolve() {
        return getInstance();
    }

    public Graph<City> getCities(){
		return this.graph;
    }
}