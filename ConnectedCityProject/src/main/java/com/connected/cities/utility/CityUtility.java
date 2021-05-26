package com.connected.cities.utility;

import java.util.logging.Logger;

/**
 *
 * @author THANISSHKA
 */
public class CityUtility {

	/**
	 * Checks if inserted cities are the same.
	 * 
	 * @param cityA starting point.
	 * @param cityB end point.
     * @return 
	 */
	public static boolean isBothCitySame(final String cityA, final String cityB) {
		log.info("both the cities are same");
		return cityA.trim().toLowerCase().equals(cityB.trim().toLowerCase());
	}
    private static final Logger log = Logger.getLogger(CityUtility.class.getName());

}
