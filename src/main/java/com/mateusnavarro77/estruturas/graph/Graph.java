package com.mateusnavarro77.estruturas.graph;

import com.mateusnavarro77.estruturas.bag.Bag;
import com.mateusnavarro77.estruturas.bag.LinkedListBag;

public class Graph {
    private static String NEW_LINE = "\n";
    private final int verticesCount;
    private int edgesCount;
    private final Bag<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int verticesCount) {
        if (verticesCount < 0)
            throw new IllegalArgumentException("Vertices Count cannot be negative.");
        this.verticesCount = verticesCount;
        this.edgesCount = 0;

        adj = (Bag<Integer>[]) new Bag[verticesCount];
        for (int i = 0; i < verticesCount; i++) {
            adj[i] = new LinkedListBag<Integer>();
        }
    }

    public void addEdge(int v1, int v2) {
        validateVertex(v1);
        validateVertex(v2);
        edgesCount++;
        adj[v1].add(v2);
        adj[v2].add(v1);
    }

    public int vertices() {
        return this.verticesCount;
    }

    public int edges() {
        return this.edgesCount;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= this.verticesCount)
            throw new IllegalArgumentException("Vertice " + v + " Must be between 0 and " + this.verticesCount);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Vertices Count: " + this.verticesCount);
        s.append(NEW_LINE);
        s.append("Edges count: " + this.edgesCount);
        s.append(NEW_LINE);
        s.append("Graph:");
        s.append(NEW_LINE);
        for (int i = 0; i < this.verticesCount; i++) {
            s.append(i + ": ");

            for (int verticeIn : adj[i]) {
                s.append(verticeIn + " ");
            }

            s.append(NEW_LINE);
        }
        return s.toString();
    }
}
