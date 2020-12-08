package com.connected.cities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.connected.cities.factory.GraphBuilder;
import com.connected.cities.factory.UndirectedGraphBuilder;
import com.connected.cities.model.City;
import com.connected.cities.model.Graph;

@RunWith(SpringRunner.class)
public class UndirectedGraphBuilderTest {
	
	@Before
    public void setUp() {}
    
    @Test
    public void build_graph() {
    
    	GraphBuilder gb=new UndirectedGraphBuilder();
    	try {
    		Graph<City> g=gb.buildGraph();
    		assertThat(g.getAdjVertices().keySet().size()).isEqualTo(18);
    	}catch(Exception ex) {
    		assertTrue(ex instanceof NullPointerException);
    	}
    	
    	
    }
}
