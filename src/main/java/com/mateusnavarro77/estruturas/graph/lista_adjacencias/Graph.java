package com.mateusnavarro77.estruturas.graph.lista_adjacencias;

import java.util.LinkedList;

import com.mateusnavarro77.estruturas.graph.IGraph;

public class Graph implements IGraph {
    private int vertices;
    private int edges;
    private LinkedList<Integer>[] adj;

    Graph(int verticesAmount) {
        this.vertices = verticesAmount;
        this.edges = 0;
        adj = new LinkedList[verticesAmount];
        for (int i = 0; i < verticesAmount; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    @Override
    public int verticesAmount() {
        return vertices;
    }

    @Override
    public int edgesAmount() {
        return this.edges;
    }

    @Override
    public void addEdge(int v1, int v2) {
        validateVertex(v1);
        validateVertex(v2);
        this.edges++;
        this.adj[v1].add(v2);
        this.adj[v2].add(v1);
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= this.vertices)
            throw new IllegalArgumentException();
    }

}
