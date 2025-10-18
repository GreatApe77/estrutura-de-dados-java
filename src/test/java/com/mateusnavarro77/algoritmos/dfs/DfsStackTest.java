package com.mateusnavarro77.algoritmos.dfs;

import org.junit.Test;

import com.mateusnavarro77.estruturas.graph.lista_adjacencias.Graph;

public class DfsStackTest {
    @Test
    public void testExecute() {
        Graph g = new Graph(11);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 5);
        g.addEdge(1, 5);
        g.addEdge(1, 6);
        g.addEdge(1, 7);
        g.addEdge(2, 7);
        g.addEdge(3, 4);
        g.addEdge(4, 8);
        g.addEdge(5, 6);
        g.addEdge(5, 9);
        g.addEdge(6, 7);
        g.addEdge(9, 10);
        DfsStack dfs = new DfsStack(g);
        dfs.execute(4);
        System.out.println(dfs.getVisitedMap());
    }
}
