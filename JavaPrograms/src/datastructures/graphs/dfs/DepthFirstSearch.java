package datastructures.graphs.dfs;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {

    public static void main(String[] args) {

        int vertices = 7;
        boolean[] visited = new boolean[vertices];
        int source = 0;

        List<List<Integer>> adj = createSampleGraph(vertices);



        // for Connected and Undirected Graph
        dfs(adj, source, visited);

        // for Disconnected and Undirected Graph
        boolean[] visited1 = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited1[i]) {
                dfs(adj, i, visited1);
            }
        }

    }

    private static void dfs(List<List<Integer>> adj, int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(source + " ");
        for (int neighbour : adj.get(source)) {
            if (!visited[neighbour])
                dfs(adj, neighbour, visited);
        }
    }

    private static List<List<Integer>> createSampleGraph(int n) {
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency List
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        addBiEdge(adj, 0, 1);
        addBiEdge(adj, 0, 2);
        addBiEdge(adj, 1, 3);
        addBiEdge(adj, 2, 4);
        addBiEdge(adj, 3, 2);
        addBiEdge(adj, 5, 6);
        return adj;
    }

    private static void addBiEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
