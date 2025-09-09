package datastructures.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphUsingEdgeList {

    int vertices;
    List<Edge> edges;

    GraphUsingEdgeList(int vertices) {
        this.vertices = vertices;
        edges = new LinkedList<>();
    }

    void addEdge(int src, int dst, int wt) {
        edges.add(new Edge(src, dst, wt));
    }

    @Override
    public String toString() {
        return "GraphUsingEdgeList{" +
                "vertices=" + vertices +
                ", edges=" + edges +
                '}';
    }

    private static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "source=" + source +
                    ", destination=" + destination +
                    ", weight=" + weight +
                    '}';
        }
    }
}
