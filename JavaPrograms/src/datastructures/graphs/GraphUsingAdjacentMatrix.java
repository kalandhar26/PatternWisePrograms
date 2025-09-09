package datastructures.graphs;

import java.util.Arrays;

public class GraphUsingAdjacentMatrix {

    int nodes;
    boolean[][] adjacentMatrix;

    GraphUsingAdjacentMatrix(int nodes) {
        this.nodes = nodes;
        adjacentMatrix = new boolean[nodes + 1][nodes + 1];
    }

    void addEdge(int src, int dst) {
        adjacentMatrix[src][dst] = true;
        adjacentMatrix[dst][src] = true;
    }

    @Override
    public String toString() {
        return "GraphUsingAdjacentMatrix{" +
                "nodes=" + nodes +
                ", adjacentMatrix=" + Arrays.deepToString(adjacentMatrix) +
                '}';
    }
}
