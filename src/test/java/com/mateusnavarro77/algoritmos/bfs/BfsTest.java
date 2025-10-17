package com.mateusnavarro77.algoritmos.bfs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mateusnavarro77.estruturas.graph.lista_adjacencias.Graph;

public class BfsTest {
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
        Bfs bfs = new Bfs(g);
        bfs.execute(6);
        System.out.println(bfs.getVisitedMap());
        System.out.println(bfs.getDistanceFromSourceMap());
        System.out.println(bfs.getPreviousVisitationList());
        System.out.println(bfs.getShortestPathFromSourceToDest(10));
    }
}
