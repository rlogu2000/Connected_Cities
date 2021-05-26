package com.connected.cities.services;

/**
 *
 * @author THANISSHKA
 */
public interface IRouteService {

    /**
     *
     * @param startPoint
     * @param endPoint
     * @return
     */
    public String findConnection(final String startPoint, final String endPoint);

}
