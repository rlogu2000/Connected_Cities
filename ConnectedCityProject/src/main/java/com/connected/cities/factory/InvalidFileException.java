/**
 * 
 */
package com.connected.cities.factory;

/**
 * @author loganathan
 *
 */
public class InvalidFileException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public InvalidFileException() {
	}
	
	public InvalidFileException(String message) {
        super(message);
    }
	
	public InvalidFileException(String message, Throwable cause) {
        super(message, cause);
    }

}
