package com.mateusnavarro77.estruturas.graph.lista_adjacencias;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GraphTest {
    
    @Test
    public void shouldTestIfHasEdge() {
        var g = new Graph(5);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        boolean hasEdge = g.hasEdge(4, 0);
        boolean hasEdge2 = g.hasEdge(0, 4);
        assertTrue(hasEdge);
        assertTrue(hasEdge2);
    }

    @Test
    public void shouldReturnFalseIfThereIsNoEdge() {
        var g = new Graph(5);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        boolean hasEdge = g.hasEdge(2, 0);
        boolean hasEdge2 = g.hasEdge(0, 2);
        assertFalse(hasEdge);
        assertFalse(hasEdge2);
    }
}
