package com.mateusnavarro77.estruturas.graph.matriz_adjacencias;

import java.util.Arrays;

import com.mateusnavarro77.estruturas.graph.IGraph;

public class Graph implements IGraph {
    private int verticesAmount;
    private int edgesAmount;
    private int[][] adjMatrix;

    public Graph(int verticesAmount) {
        this.verticesAmount = verticesAmount;
        this.edgesAmount = 0;
        adjMatrix = new int[verticesAmount][verticesAmount];
    }

    @Override
    public int verticesAmount() {
        return this.verticesAmount;
    }

    @Override
    public int edgesAmount() {
        return this.edgesAmount;
    }

    @Override
    public void addEdge(int v1, int v2) {
        validateVertex(v1);
        validateVertex(v2);
        this.edgesAmount++;
        adjMatrix[v1][v2] = 1;
        adjMatrix[v2][v1] = 1;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= this.verticesAmount)
            throw new IllegalArgumentException();
    }

    public String toMatrix() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < verticesAmount; i++) {
            for (int j = 0; j < verticesAmount; j++) {
                sb.append(adjMatrix[i][j]);
                if (j < verticesAmount - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var g = new Graph(5);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        System.out.println(g.toMatrix());
    }
}
