/**
 * 
 */
package com.connected.cities.factory;

/**
 * @author THANISSHKA
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
		// TODO Auto-generated constructor stub
	}
	
	public InvalidFileException(String message) {
        super(message);
    }
	
	public InvalidFileException(String message, Throwable cause) {
        super(message, cause);
    }

}
