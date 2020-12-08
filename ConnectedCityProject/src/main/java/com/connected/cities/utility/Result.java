package com.connected.cities.utility;

import java.io.Serializable;

import com.google.gson.Gson;

public class Result implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String result;
	Gson gson = new Gson();

	public Result(String result) {
		this.result=result;
	}
	@Override
	public String toString() {
		return gson.toJson(this.result);
	}
	

}
