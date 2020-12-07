package com.connected.cities.utility;

public class CityUtility {
	
	/**
	 * Checks if inserted cities are the same.
	 * @param cityA starting point.
	 * @param cityB end point.
	 * */
	public static boolean isBothCitySame(final String cityA,final String cityB){
		if(cityA.trim().toLowerCase().equals(cityB.trim().toLowerCase())){
			return true;
		}
		return false;
	}

}
