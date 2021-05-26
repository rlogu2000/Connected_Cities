package com.connected.cities.utility;

import com.connected.cities.factory.City;
import com.connected.cities.factory.Graph;
import com.connected.cities.factory.InvalidFileException;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Loganathan.
 */
public enum CityGraphSingleton {

    /**
     *
     */
    INSTANCE;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	private Graph<City> graph = null;

	private CityGraphSingleton() {
		log.info("Singleton Insance Created");
		createRoutes();

	}

    /**
     *
     * @return
     */
    public static CityGraphSingleton getInstance() {
		return INSTANCE;
	}

	private void createRoutes() {
		try {
			RoutesBuilder rb = new RoutesBuilder();
			this.graph = rb.buildPath();
			log.info("***The final Graph ***" + graph);
		} catch (IOException ex) {
			log.info("IOException :" + ex);
			Terminator.terminate(ex.getMessage(), 1);
		} catch (InvalidFileException ex) {
			log.info("InvalidFileException:" + ex);
			Terminator.terminate(ex.getMessage(), 1);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			Terminator.terminate(ex.getMessage(), 1);
		}
	}

    /**
     *
     * @return
     */
    protected Object readResolve() {
		return getInstance();
	}

    /**
     *
     * @return
     */
    public Graph<City> getCities() {
		return this.graph;
	}
}