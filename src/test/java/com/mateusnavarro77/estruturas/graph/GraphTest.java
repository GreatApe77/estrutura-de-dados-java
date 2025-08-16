package com.mateusnavarro77.estruturas.graph;

import org.junit.Test;

public class GraphTest {

    @Test
    public void shouldCreate() {
        Graph graph = new Graph(10);
        graph.addEdge(0, 0);
        graph.addEdge(0, 0);
        graph.addEdge(0, 1);
        graph.addEdge(1, 9);
        graph.addEdge(2, 3);
        graph.addEdge(9, 8);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 9);
        graph.addEdge(1, 2);
        graph.addEdge(2, 9);
        graph.addEdge(2, 4);
        graph.addEdge(3, 7);
        System.out.println(graph.toString());
    }
}
