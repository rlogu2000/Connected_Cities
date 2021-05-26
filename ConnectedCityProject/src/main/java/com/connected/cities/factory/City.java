package com.connected.cities.factory;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@EqualsAndHashCode
@Getter
@Setter
public class City implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    /**
     *
     * @param cityName
     * @return
     */
    public static City valueOf(final String cityName) {
        return new City(cityName);
    }

	/* City name. */
	@ApiModelProperty(notes = "Name of the City")
	private final String name;

	/**
	 * Constructor
	 *
	 * @param name city name.
	 */
	public City(String name) {
		this.name = name;

	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
                sb = sb.append("[ Name : ").append(name).append("]"); 
		return sb.toString();
	}
}
