package com.connected.cities.utility;

import com.connected.cities.factory.City;
import com.connected.cities.factory.Graph;
import com.connected.cities.factory.GraphBuilder;

import static com.connected.cities.factory.GraphBuilderFactory.UNDIRECTED_GRAPH;
import static com.connected.cities.factory.GraphBuilderFactory.createGraphBuilder;
import com.connected.cities.factory.InvalidFileException;
import java.io.IOException;

/**
 * Builds connections between cities.
 */
public class RoutesBuilder {

    /**
     *
     */
    public RoutesBuilder() {

	}

    /**
     *
     * @return
     * @throws Exception
     */
    public Graph<City> buildPath() throws Exception {
		try {
			GraphBuilder gb = createGraphBuilder(UNDIRECTED_GRAPH);
			Graph<City> g = gb.buildGraph();

			return g;
		} catch (IOException | InvalidFileException ex) {
			// log.error(ex.getMessage(), ex); //No need to log exception here, we need to
			// log at the starting point
			throw ex;
		} catch (Exception ex) {
			// log.error(ex.getMessage(), ex); //No need to log exception here, we need to
			// log at the starting point
			throw ex;
		}
	}
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(RoutesBuilder.class.getName());

}
