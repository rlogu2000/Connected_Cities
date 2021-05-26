package com.connected.cities.factory;

import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author THANISSHKA
 */
public class DirectedAcyclicGraphBuilder extends GraphBuilder {

    /**
     *
     * @return
     * @throws IOException
     * @throws InvalidFileException
     * @throws Exception
     */
    @Override
	public Graph<City> buildGraph() throws IOException, InvalidFileException, Exception {
		throw new UnsupportedOperationException("Implementation is not complete");
	}

    /**
     *
     * @param file
     * @return
     * @throws IOException
     * @throws InvalidFileException
     * @throws Exception
     */
    @Override
	public Graph<City> buildGraph(String file) throws IOException, InvalidFileException, Exception {
		throw new UnsupportedOperationException("Implementation is not complete");
	}
    private static final Logger LOG = Logger.getLogger(DirectedAcyclicGraphBuilder.class.getName());
}
