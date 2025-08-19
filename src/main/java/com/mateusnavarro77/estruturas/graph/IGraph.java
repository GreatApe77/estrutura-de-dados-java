package com.mateusnavarro77.estruturas.graph;

public interface IGraph {
    int verticesAmount();

    int edgesAmount();

    void addEdge(int v1, int v2);

}