package com.connected.cities.factory;

import java.util.logging.Logger;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author THANISSHKA
 * @param <T>
 */
@Getter
@Setter
@EqualsAndHashCode
public class Vertex<T> {

	private final T object;

    /**
     *
     * @param object
     */
    public Vertex(T object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return object.toString();
	}
    private static final Logger LOG = Logger.getLogger(Vertex.class.getName());
}
