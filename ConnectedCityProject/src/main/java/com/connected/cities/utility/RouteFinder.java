package com.connected.cities.utility;

import com.connected.cities.search.strategy.GraphSearchStrategy;

/**
 *
 * @author THANISSHKA
 */
public class RouteFinder {

	/**
     * @param gss
	 * @return false if there is no connection between to cities.
	 */

	public boolean isConnected(GraphSearchStrategy gss) {
		try {
			return gss.search();
		} catch (Exception ex) {
			log.info("Exception : " + ex);
		}
		return false;
	}
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(RouteFinder.class.getName());
}
