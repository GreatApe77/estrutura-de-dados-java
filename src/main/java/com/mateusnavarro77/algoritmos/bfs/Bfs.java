package com.mateusnavarro77.algoritmos.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.mateusnavarro77.estruturas.graph.lista_adjacencias.Graph;;

public class Bfs {
    private boolean[] marked;
    private int[] distanceFromSource;
    private Queue<Integer> queue;
    private Graph originalGraph;
    // private int layerCount = 0;

    public Bfs(Graph g) {
        this.marked = new boolean[g.verticesAmount()];
        this.distanceFromSource = new int[g.verticesAmount()];
        this.queue = new LinkedList<Integer>();
        this.originalGraph = g;
    }

    public List<Integer> getDistanceFromSourceMap() {
        List<Integer> l = new ArrayList<Integer>(distanceFromSource.length);
        for (int i = 0; i < distanceFromSource.length; i++) {
            l.add(distanceFromSource[i]);
        }
        return l;
    }

    public List<Boolean> getVisitedMap() {
        List<Boolean> l = new ArrayList<Boolean>(marked.length);
        for (int i = 0; i < marked.length; i++) {
            l.add(marked[i]);
        }
        return l;
    }

    public void execute(int startingVertex) {
        _bfs(startingVertex);
        System.out.println("Terminou");
    }

    private void _bfs(int startingVertex) {
        if (!marked[startingVertex]) {
            marked[startingVertex] = true;
            queue.offer(startingVertex);
            // distanceFromSource[startingVertex] = layerCount;
            // layerCount++;

        }
        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (int adjacent : originalGraph.adjacentsOf(current)) {
                if (!marked[adjacent]) {
                    marked[adjacent] = true;
                    queue.offer(adjacent);
                    // distanceFromSource[adjacent] = layerCount;
                }
            }
            // layerCount++;

            // for (int i = 0; i < originalGraph.adjacentsOf(current).size(); i++) {

            // if (!marked[i]) {
            // marked[i] = true;
            // queue.offer(i);
            // }
            // }
        }
    }
}
