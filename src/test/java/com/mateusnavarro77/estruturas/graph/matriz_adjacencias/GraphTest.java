package com.mateusnavarro77.estruturas.graph.matriz_adjacencias;

import org.junit.Test;

public class GraphTest {


    @Test
    public void shouldPrintArray(){
        var g = new Graph(5);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        System.out.println(g.toMatrix());
    }
}
