package com.connected.cities.utility;

/**
 * Contain Error message.
 * */
public enum ErrorMessages {
	FILE_NOT_FOUND("cities.txt file is not found."),
	FILE_IS_EMPTY("cities.txt file file is empty!");
	private String errorMsg;

	private ErrorMessages(String msg) {
		this.errorMsg = msg;
	}

	public final String value() {
		return this.errorMsg;
	}
}
