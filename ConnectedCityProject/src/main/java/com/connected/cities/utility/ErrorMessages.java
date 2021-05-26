package com.connected.cities.utility;

/**
 * Contain Error message.
 */
public enum ErrorMessages {

    /**
     *
     */
    FILE_NOT_FOUND("cities.txt file is not found."), 

    /**
     *
     */
    FILE_IS_EMPTY("cities.txt file file is empty!");
	private final String errorMsg;

	private ErrorMessages(String msg) {
		this.errorMsg = msg;
	}

    /**
     *
     * @return
     */
    public String value() {
		return this.errorMsg;
	}
}
