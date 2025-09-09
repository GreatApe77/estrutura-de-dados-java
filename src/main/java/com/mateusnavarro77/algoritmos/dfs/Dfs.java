package com.mateusnavarro77.algoritmos.dfs;

import java.util.ArrayList;

import com.mateusnavarro77.estruturas.graph.lista_adjacencias.Graph;;

public class Dfs {
    private int count = 0;
    ArrayList<Integer> visitationOrder = new ArrayList<Integer>();

    public int getCount() {
        return count;
    }

    void dfs(Graph graph, int startingPoint) {
        int v = graph.verticesAmount();
        boolean[] marked = new boolean[v];

        _dfs(graph, startingPoint, marked);

    }

    private void _dfs(Graph graph, int startingPoint, boolean[] marked) {
        count++;
        marked[startingPoint] = true;
        visitationOrder.add(startingPoint);
        for (Integer neighbor : graph.adjacentsOf(startingPoint)) {
            if (!marked[neighbor]) {
                _dfs(graph, neighbor, marked);
            }
        }
    }

    public void printRoute() {
        for (int i = 0; i < visitationOrder.size(); i++) {
            System.out.println(visitationOrder.get(i));
            if (i != visitationOrder.size() - 1) {

                System.out.println("|");
                System.out.println("v");
            }
        }
    }
}
