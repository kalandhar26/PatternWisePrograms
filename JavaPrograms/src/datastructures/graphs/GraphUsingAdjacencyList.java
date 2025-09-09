package datastructures.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GraphUsingAdjacencyList {

    int vertices;
   List<Integer>[] adjList;

    GraphUsingAdjacencyList(int vertices) {
        this.vertices = vertices;
        this.adjList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dst) {
        adjList[src].add(dst);
        adjList[dst].add(src);
    }

    @Override
    public String toString() {
        return "GraphUsingAdjacencyList{"
                + vertices +
                "," + Arrays.deepToString(adjList) +
                '}';
    }
}
