package com.mateusnavarro77.algoritmos.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.mateusnavarro77.estruturas.graph.lista_adjacencias.Graph;;

public class Bfs {
    private boolean[] marked;
    private int[] distanceFromSource;
    private int[] previous;
    private Queue<Integer> queue;
    private Graph originalGraph;

    public Bfs(Graph g) {
        this.marked = new boolean[g.verticesAmount()];
        this.distanceFromSource = new int[g.verticesAmount()];
        this.queue = new LinkedList<Integer>();
        this.previous = new int[g.verticesAmount()];
        Arrays.fill(this.previous, -1);
        this.originalGraph = g;
    }

    public List<Integer> getPreviousVisitationList() {
        List<Integer> l = new ArrayList<Integer>(previous.length);
        for (int i = 0; i < previous.length; i++) {
            l.add(previous[i]);
        }
        return l;
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
        source = startingVertex;
        _bfs(startingVertex);

    }

    public List<Integer> getShortestPathFromSourceToDest(int dest) {
        List<Integer> path = new LinkedList<>();
        path.add(dest);

        int ancestor = previous[dest];
        while (ancestor != -1) {
            path.add(ancestor);
            ancestor = previous[ancestor];
        }
        return path.reversed();
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
                    previous[adjacent] = current;
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
