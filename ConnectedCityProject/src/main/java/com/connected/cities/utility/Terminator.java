package com.connected.cities.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Terminator used to terminate the program.
 * */
public class Terminator {
	/**
	 * Terminate program, and view exit message details.
	 *
	 * @param message
	 *            message to view to the user before terminating.
	 * @param status
	 *            integer representation of the exist status.
	 * */
	private static final Logger log = LoggerFactory.getLogger(Terminator.class);
	public static void terminate(final String message, final int status) {
		log.info(message);
		System.exit(status);
	}

	public static void yes() {
		terminate("yes", 0);
	}

	public static void no() {
		terminate("no", 0);
	}
}
