package com.connected.cities.factory;

import java.util.ArrayList;
import static java.util.Collections.unmodifiableList;
import static java.util.Collections.unmodifiableMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static java.util.Optional.ofNullable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import lombok.ToString;

/**
 *
 * @author THANISSHKA
 * @param <T>
 */
@ToString
public class Graph<T> {

	private final Map<Vertex<T>, List<Vertex<T>>> adjVertices = new ConcurrentHashMap<>();

    /**
     *
     * @param object
     */
    protected void addVertex(T object) {
		adjVertices.putIfAbsent(new Vertex<>(object), new ArrayList<>());
	}

    /**
     *
     * @param object
     */
    protected void removeVertex(T object) {
		Vertex<T> v = new Vertex<>(object);
		adjVertices.values().stream().forEach(e -> e.remove(v));
		adjVertices.remove(new Vertex<>(object));
	}

    /**
     *
     * @param object1
     * @param object2
     */
    protected void addEdge(T object1, T object2) {
		Vertex<T> v1 = new Vertex<>(object1);
		Vertex<T> v2 = new Vertex<>(object2);
		if (!adjVertices.get(v1).contains(v2)) {
                    adjVertices.get(v1).add(v2);
        }
		if (!adjVertices.get(v2).contains(v1)) {
                    adjVertices.get(v2).add(v1);
        }
	}

    /**
     *
     * @param object1
     * @param object2
     */
    protected void removeEdge(T object1, T object2) {
		Vertex<T> v1 = new Vertex<>(object1);
		Vertex<T> v2 = new Vertex<>(object2);
		List<Vertex<T>> eV1 = adjVertices.get(v1);
		List<Vertex<T>> eV2 = adjVertices.get(v2);
		if (eV1 != null) {
                    eV1.remove(v2);
        }
		if (eV2 != null) {
                    eV2.remove(v1);
        }
	}

    /**
     *
     * @param object
     * @return
     */
    public Optional<List<Vertex<T>>> getAdjVertices(T object) {
		return ofNullable(unmodifiableList(adjVertices.get(new Vertex<>(object))));
	}

    /**
     *
     * @return
     */
    public Map<Vertex<T>, List<Vertex<T>>> getAdjVertices() {
		return unmodifiableMap(adjVertices);
	}

    /**
     *
     * @param label
     * @return
     */
    public Vertex<T> createVertex(T label) {
		return new Vertex<>(label);
	}
    private static final Logger LOG = Logger.getLogger(Graph.class.getName());

}
