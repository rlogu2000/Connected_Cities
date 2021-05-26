package com.connected.cities.factory;

import java.util.logging.Logger;

/**
 *
 * @author THANISSHKA
 */
public class DirectedWeightedGraph extends GraphBuilder {

    /**
     *
     * @return
     * @throws InvalidFileException
     */
    @Override
	public Graph<City> buildGraph() throws InvalidFileException {
		throw new UnsupportedOperationException("Implementation is not complete");
	}

    /**
     *
     * @param file
     * @return
     * @throws InvalidFileException
     */
    @Override
	public Graph<City> buildGraph(String file) throws InvalidFileException {
		throw new UnsupportedOperationException("Implementation is not complete");
	}
    private static final Logger LOG = Logger.getLogger(DirectedWeightedGraph.class.getName());
}
