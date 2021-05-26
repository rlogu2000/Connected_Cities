package com.connected.cities.factory;

/**
 *
 * @author THANISSHKA
 */
public class GraphBuilderFactory {

    /**
     *
     */
    public static final String DIRECTED_GRAPH = "directed";

    /**
     *
     */
    public static final String UNDIRECTED_GRAPH = "undirected";

    /**
     *
     */
    public static final String DIRECTED_ACYLIC_GRAPH = "directedaclyic";

    /**
     *
     */
    public static final String DIRECTED_WEIGHTED_GRAPH = "directedweighted";

	
    /**
     *
     * @param type
     * @return
     */
    public static GraphBuilder createGraphBuilder(String type) {
		log.info("Graph Type " + type);
		if (type == null) {
                    return null;
        }
		if (type.equalsIgnoreCase(DIRECTED_GRAPH)) {
			return new DirectedGraphBuilder();
		} else if (type.equalsIgnoreCase(UNDIRECTED_GRAPH)) {
			return new UndirectedGraphBuilder();
		} else if (type.equalsIgnoreCase(DIRECTED_ACYLIC_GRAPH)) {
			return new DirectedAcyclicGraphBuilder();
		} else if (type.equalsIgnoreCase(DIRECTED_WEIGHTED_GRAPH)) {
			return new DirectedWeightedGraph();
		}
		return null;
	}
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(GraphBuilderFactory.class.getName());
}
