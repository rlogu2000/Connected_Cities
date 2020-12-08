package com.connected.cities;

import static org.assertj.core.api.Assertions.assertThat;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.test.context.junit4.SpringRunner;

import com.connected.cities.model.City;
import com.connected.cities.model.Graph;


@RunWith(SpringRunner.class)
public class GraphTest {
	
	@Before
    public void setUp() {}
    
    @Test
    public void create_graph_object() {
        Graph<City> graph = new Graph<City>();
		String edges[] = {"NewYork","NewJersey"}; 
		City cityA=City.valueOf(edges[0].trim());	
		City cityB=City.valueOf(edges[1].trim());	
		graph.addVertex(cityA);
		graph.addVertex(cityB);
		graph.addEdge(cityA,cityB);
		
		edges=new String[]{"Princeton","Edison"}; 
		cityA=City.valueOf(edges[0].trim());	
		cityB=City.valueOf(edges[1].trim());	
		graph.addVertex(cityA);
		graph.addVertex(cityB);
		graph.addEdge(cityA,cityB);
		
		edges=new String[]{"LosAngels","LosVegas"}; 
		cityA=City.valueOf(edges[0].trim());	
		cityB=City.valueOf(edges[1].trim());	
		graph.addVertex(cityA);
		graph.addVertex(cityB);
		graph.addEdge(cityA,cityB);
		
		edges=new String[]{"Sanfrancisco","Washington"}; 
		cityA=City.valueOf(edges[0].trim());	
		cityB=City.valueOf(edges[1].trim());	
		graph.addVertex(cityA);
		graph.addVertex(cityB);
		graph.addEdge(cityA,cityB);
		
		edges=new String[]{"Boton","Denwar"}; 
		cityA=City.valueOf(edges[0].trim());	
		cityB=City.valueOf(edges[1].trim());	
		graph.addVertex(cityA);
		graph.addVertex(cityB);
		graph.addEdge(cityA,cityB);
		
		edges=new String[]{"Boton","NewYork"}; 
		cityA=City.valueOf(edges[0].trim());	
		cityB=City.valueOf(edges[1].trim());	
		graph.addVertex(cityA);
		graph.addVertex(cityB);
		graph.addEdge(cityA,cityB);
		
		assertThat(graph.getAdjVertices(City.valueOf("NewYork")).get().size()).isEqualTo(2);
		
    }
    @Test(expected=NullPointerException.class)
    public void adding_null_edges() {
    	Graph<City> graph = new Graph<City>();
		String edges[] = {"NewYork","NewJersey"}; 
		City cityA=City.valueOf(edges[0].trim());	
		City cityB=City.valueOf(edges[1].trim());	
		graph.addEdge(cityA,cityB);
    }
}

