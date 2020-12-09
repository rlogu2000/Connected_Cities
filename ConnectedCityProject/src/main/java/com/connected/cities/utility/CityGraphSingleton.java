package com.connected.cities.utility;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.connected.cities.factory.City;
import com.connected.cities.factory.Graph;
import com.connected.cities.factory.InvalidFileException;

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
    	}catch(IOException ex) {
    		log.info("IOException :"+ex); 
	    	ex.printStackTrace();
    		Terminator.terminate(ex.getMessage(), 1);
    	}
    	catch(InvalidFileException ex) {
    		log.info("InvalidFileException:"+ex); 
	    	ex.printStackTrace();
    		Terminator.terminate(ex.getMessage(), 1);
    	}
    	catch(Exception ex) {
	    	log.error(ex.getMessage(), ex); 
	    	ex.printStackTrace();
    		Terminator.terminate(ex.getMessage(), 1);
    	}
    }
    protected Object readResolve() {
        return getInstance();
    }

    public Graph<City> getCities(){
		return this.graph;
    }
}