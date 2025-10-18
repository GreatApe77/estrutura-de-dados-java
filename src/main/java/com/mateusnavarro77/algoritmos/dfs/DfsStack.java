package com.mateusnavarro77.algoritmos.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.mateusnavarro77.estruturas.graph.lista_adjacencias.Graph;

public class DfsStack {

    private boolean[] marked;
    private Stack<Integer> stack;
    private Graph originalGraph;

    public List<Boolean> getVisitedMap() {
        List<Boolean> l = new ArrayList<Boolean>(marked.length);
        for (int i = 0; i < marked.length; i++) {
            l.add(marked[i]);
        }
        return l;
    }

    public DfsStack(Graph g) {
        this.marked = new boolean[g.verticesAmount()];
        this.stack = new Stack<Integer>();
        this.originalGraph = g;
    }

    public void execute(int startingVertex) {
        marked[startingVertex] = true;
        stack.push(startingVertex);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            marked[current] = true;
            for (int adjacent : this.originalGraph.adjacentsOf(current)) {
                if (!marked[adjacent]) {
                    stack.push(adjacent);
                }
            }
        }
    }

}
