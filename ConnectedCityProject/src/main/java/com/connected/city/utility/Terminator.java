package com.connected.city.utility;

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
	public static void terminate(final String message, final int status) {
		System.out.println(message);
		System.exit(status);
	}

	public static void yes() {
		terminate("yes", 0);
	}

	public static void no() {
		terminate("no", 0);
	}
}
