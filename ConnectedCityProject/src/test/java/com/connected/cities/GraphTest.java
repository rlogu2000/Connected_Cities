package com.connected.cities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.connected.cities.factory.City;
import com.connected.cities.factory.Graph;
import com.connected.cities.factory.GraphBuilder;
import com.connected.cities.factory.GraphBuilderFactory;
import com.connected.cities.factory.InvalidFileException;

@RunWith(SpringRunner.class)
public class GraphTest {

	@Before
	public void setUp() {
	}

	@Test
	public void create_graph_object_and_check_NewYork_Edges() {
		try {
			GraphBuilder gb = GraphBuilderFactory.createGraphBuilder(GraphBuilderFactory.UNDIRECTED_GRAPH);
			Graph<City> graph = gb.buildGraph();
			assertThat(graph.getAdjVertices(City.valueOf("NewYork".toLowerCase())).get().size()).isEqualTo(4);
		} catch (IOException | InvalidFileException ex) {
			Assert.fail("IOException or InvalidFileException thrown and which is not Expected :" + ex.getMessage());
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail("Exception thrown and which is not Expected :" + ex.getMessage());
		}
	}

	@Test
	public void invalid_File_Exception() {
		try {
			GraphBuilder gb = GraphBuilderFactory.createGraphBuilder(GraphBuilderFactory.UNDIRECTED_GRAPH);
			gb.buildGraph("cities_invalid_file.txt");
			Assert.fail("Expecting InvalidFileException, But File pass thru fine with out Exception whihc is not good");
		} catch (InvalidFileException ex) {
			assertTrue(ex instanceof InvalidFileException);
		} catch (IOException ex) {
			assertTrue(ex instanceof IOException);
		} catch (Exception ex) {
			assertTrue(ex instanceof Exception);
		}
	}
}
