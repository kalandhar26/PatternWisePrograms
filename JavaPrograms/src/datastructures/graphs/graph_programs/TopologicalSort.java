package datastructures.graphs.graph_programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// This is possible in Directed Acyclic Graph
public class TopologicalSort {

    public static void main(String[] args) {
        // Example graph: 5 vertices, edges: 0->1, 0->2, 1->3, 2->3, 2->4
        int vertexCount = 5;
        List<List<Integer>> adjacencyList = new ArrayList<>();

        // Initialize adjacency list for 0-based indexing
        for (int i = 0; i < vertexCount; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Add directed edges
        adjacencyList.get(0).add(1);
        adjacencyList.get(0).add(2);
        adjacencyList.get(1).add(3);
        adjacencyList.get(2).add(3);
        adjacencyList.get(2).add(4);

        // Get topological sort
        int[] result = topologicalSort(vertexCount, adjacencyList);

        // Print result
        System.out.print("Topological Sort: ");
        for (int vertex : result) {
            System.out.print(vertex + " ");
        }

        // Expected output: 0 2 4 1 3 (one possible valid order)
    }

    private static void dfsForTopologicalSort(int source, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj){
        visited[source]=true;
        for(int neighbour : adj.get(source)){
            if(!visited[neighbour]){
                dfsForTopologicalSort(neighbour,visited,stack,adj);
            }
        }
        stack.push(source);
    }

    private static  int[] topologicalSort(int vertices, List<List<Integer>> adj){
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        for(int vertex=0;vertex<vertices;vertex++){
            if(!visited[vertex]){
                dfsForTopologicalSort(vertex,visited,stack,adj);
            }
        }

        int[] result = new int[vertices];
        int index=0;
        while (!stack.isEmpty()){
            result[index++] = stack.pop();
        }

       return result;
    }
}
