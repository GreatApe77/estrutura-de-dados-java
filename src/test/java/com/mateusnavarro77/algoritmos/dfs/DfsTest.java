package com.mateusnavarro77.algoritmos.dfs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mateusnavarro77.estruturas.graph.lista_adjacencias.*;

public class DfsTest {

    @Test
    public void shouldDfsAGraph() {
        var g = new Graph(10);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 7);
        g.addEdge(7, 8);
        g.addEdge(8, 9);
        g.addEdge(9, 0);
        g.addEdge(0, 7);
        g.addEdge(7, 2);
        var dfs = new Dfs();
        dfs.dfs(g, 0);
        dfs.printRoute();
        assertEquals(dfs.getCount(), 10);
    }
}
