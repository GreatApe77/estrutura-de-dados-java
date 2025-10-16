package com.mateusnavarro77.algoritmos.bfs;

import org.junit.Test;

import com.mateusnavarro77.estruturas.graph.lista_adjacencias.Graph;

public class BfsTest {
    @Test
    public void testExecute() {
        Graph g = new Graph(10);
        g.addEdge(4, 3);
        g.addEdge(0, 1); 
        g.addEdge(1, 2); 
        g.addEdge(5, 9); 
        g.addEdge(3, 7); 
        g.addEdge(8, 2);
        g.addEdge(2, 3);
        g.addEdge(5, 0);
        g.addEdge(6, 9);
        Bfs bfs = new Bfs(g);
        bfs.execute(9);
        System.out.println(bfs.getVisitedMap());
        System.out.println(bfs.getDistanceFromSourceMap());
    }
}
