package com.connected.cities.factory;

import static com.connected.cities.factory.City.valueOf;
import java.io.BufferedReader;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.connected.cities.utility.FileLoader;

/**
 *
 * @author THANISSHKA
 */
public class UndirectedGraphBuilder extends GraphBuilder {

	private static final String DELIMITER = ",";
	

    /**
     *
     * @return
     * @throws IOException
     * @throws InvalidFileException
     * @throws Exception
     */
    @Override
	public Graph<City> buildGraph() throws IOException, InvalidFileException, Exception {
		return buildGraph("cities.txt");
	}

    /**
     *
     * @param file
     * @return
     * @throws IOException
     * @throws InvalidFileException
     * @throws Exception
     */
    @Override
	public Graph<City> buildGraph(String file) throws IOException, InvalidFileException, Exception {
		log.info("undirected graph builder is called");
		Graph<City> graph = new Graph<>();
		String line;
		FileLoader fileLoader = new FileLoader();
		Resource routes = new ClassPathResource(file);
		try (BufferedReader br = fileLoader.loadFile(routes.getFile())) {
			log.info("Resource file " + routes);
			while ((line = br.readLine()) != null) {
				String edges[] = getEdges(line);
				City cityA = valueOf(edges[0].trim());
				City cityB = valueOf(edges[1].trim());
				graph.addVertex(cityA);
				graph.addVertex(cityB);
				graph.addEdge(cityA, cityB);
			}
		} catch (IOException | InvalidFileException e) {
			// e.printStackTrace();
			throw e;
		} catch (Exception e) {
			// e.printStackTrace();
			throw e;
		}
		printGraph(graph);
		return graph;
	}

	private void printGraph(Graph<City> graph) {
	}

	private String[] getEdges(final String line) throws InvalidFileException {
		String[] cities = line.trim().toLowerCase().replace(DELIMITER + " ", DELIMITER).split(DELIMITER);
		if (cities.length != 2) {
			log.info("input file is not correct format ");
			throw new InvalidFileException("File Content is not Correct");
		} else {
            return cities;
        }

	}
    private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(UndirectedGraphBuilder.class.getName());

}
