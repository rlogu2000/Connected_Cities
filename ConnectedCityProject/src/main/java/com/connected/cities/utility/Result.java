package com.connected.cities.utility;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.logging.Logger;

/**
 *
 * @author loganathan.
 */
public class Result implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String result;
	Gson gson = new Gson();

    /**
     *
     * @param string
     */
    public Result(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return gson.toJson(this.result);
	}
    private static final Logger LOG = Logger.getLogger(Result.class.getName());

}
