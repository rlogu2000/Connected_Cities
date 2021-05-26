package com.connected.cities;

import com.connected.cities.factory.City;
import com.connected.cities.factory.Graph;
import com.connected.cities.factory.GraphBuilder;
import com.connected.cities.factory.InvalidFileException;
import com.connected.cities.factory.UndirectedGraphBuilder;
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Loganathan.
 */
@RunWith(SpringRunner.class)
public class UndirectedGraphBuilderTest {

    /**
     *
     */
    @Before
	public void setUp() {
	}

    /**
     *
     */
    @Test
	public void build_graph_with_valid_file() {

		GraphBuilder gb = new UndirectedGraphBuilder();
		try {
			Graph<City> g = gb.buildGraph("cities.txt");
			assertThat(g.getAdjVertices().keySet().size()).isEqualTo(18);
		} catch (IOException | InvalidFileException ex) {
			Assert.fail("IOException or InvalidFileException thrown and which is not Expected :" + ex.getMessage());
		} catch (Exception ex) {
			Assert.fail("Exception thrown and which is not Expected :" + ex.getMessage());
		}

	}
  
}
