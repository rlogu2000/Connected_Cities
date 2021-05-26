package com.connected.cities.services;

import com.connected.cities.search.strategy.DepthFirstSearchStrategy;
import com.connected.cities.search.strategy.GraphSearchStrategy;
import static com.connected.cities.utility.CityGraphSingleton.getInstance;
import com.connected.cities.utility.RouteFinder;

import org.springframework.stereotype.Service;

/**
 * Search data map for requested connection.
 */
@Service
public class RouteService implements IRouteService {



	/**
	 * Checks if there is a connection between provided starting point and end
	 * point.
     * @param startPoint
     * @param endPoint
     * @return 
	 */
	@Override
	public String findConnection(final String startPoint, final String endPoint) {
		RouteFinder rf = new RouteFinder();
		GraphSearchStrategy gss = new DepthFirstSearchStrategy(startPoint, endPoint,
				getInstance().getCities());
		if (rf.isConnected(gss)) {
			log.info("Connection Found");
			return "Yes";
		} else {
			log.info("Connection Not Found");
			return "No";
		}

	}
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(RouteService.class.getName());

}
