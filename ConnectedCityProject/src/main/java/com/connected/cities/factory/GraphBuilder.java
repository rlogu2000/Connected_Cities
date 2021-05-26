package com.connected.cities.factory;

import java.io.IOException;

/**
 *
 * @author THANISSHKA
 */
public abstract class GraphBuilder {

    /**
     *
     * @return
     * @throws IOException
     * @throws InvalidFileException
     * @throws Exception
     */
    public abstract Graph<City> buildGraph() throws IOException, InvalidFileException, Exception;

    /**
     *
     * @param file
     * @return
     * @throws IOException
     * @throws InvalidFileException
     * @throws Exception
     */
    public abstract Graph<City> buildGraph(String file) throws IOException, InvalidFileException, Exception;
}
