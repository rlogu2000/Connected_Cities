package com.connected.cities.utility;

import static java.lang.System.exit;

public class Terminator {
		

    /**
     *
     * @param message
     * @param status
     */
    public static void terminate(final String message, final int status) {
		LOG.info(message);
		exit(status);
	}

    /**
     *
     */
    public static void yes() {
		terminate("yes", 0);
	}

    /**
     *
     */
    public static void no() {
		terminate("no", 0);
	}
    private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(Terminator.class.getName());
}
