package com.connected.cities;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.connected.cities.factory.DirectedGraphBuilder;
import com.connected.cities.factory.GraphBuilder;
import com.connected.cities.factory.GraphBuilderFactory;
import com.connected.cities.factory.UndirectedGraphBuilder;

@RunWith(SpringRunner.class)
public class GraphBuilderFactoryTest {
    
    @Before
    public void setUp() {}
    
    @Test
    public void given_null_type() {
    	GraphBuilder gb=GraphBuilderFactory.createGraphBuilder(null);
        System.out.println("The Result "+gb);
        assertThat(gb).isNull();
    }
    @Test
    public void given_wrong_type() {
    	GraphBuilder gb=GraphBuilderFactory.createGraphBuilder("something");
        System.out.println("The Result "+gb);
        assertThat(gb).isEqualTo(null);
    }
    @Test
    public void given_directed_type() {
    	GraphBuilder gb=GraphBuilderFactory.createGraphBuilder("directed");
        System.out.println("The Result "+gb);
        assertThat(gb.getClass()).isEqualTo(DirectedGraphBuilder.class);
    }
    @Test
    public void given_undirected_type() {
    	GraphBuilder gb=GraphBuilderFactory.createGraphBuilder("undirected");
        System.out.println("The Result "+gb);
        assertThat(gb.getClass()).isEqualTo(UndirectedGraphBuilder.class);
    }
}
