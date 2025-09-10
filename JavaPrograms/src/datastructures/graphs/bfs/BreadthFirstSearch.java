package datastructures.graphs.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void main(String[] args) {

        int vertices = 7;
        boolean[] visited = new boolean[vertices];
        int source = 0;

        List<List<Integer>> adj = createSampleGraph(vertices);

        // for Connected and Undirected Graph
        bfs(adj, source, visited);

        // for Disconnected and Undirected Graph
        boolean[] visited1 = new boolean[vertices];
        for (int i = 0; i < vertices; i++) {
            if (!visited1[i]) {
                bfs(adj, i, visited1);
            }
        }


    }

    private static void bfs(List<List<Integer>> adj, int source, boolean[] visited) {

        if (source < 0 || source >= adj.size()) {
            throw new IllegalArgumentException("Invalid source vertex");
        }
        if (visited.length != adj.size()) {
            throw new IllegalArgumentException("Visited array size must match adjacency list size");
        }

        Queue<Integer> queue = new ArrayDeque<>();
        visited[source] = true;
        queue.add(source);

        while (!queue.isEmpty()) {
            int currentElement = queue.poll();
            // Instead of printing here we can collect in List and we can return it.
            System.out.print(currentElement + " ");
            for (int neighbour : adj.get(currentElement)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
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
