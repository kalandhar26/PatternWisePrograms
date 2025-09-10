package datastructures.graphs.graph_programs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b,
 * and city b is connected directly with city c, then city a is connected indirectly with city c.
 * <p>
 * A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 * <p>
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are
 * directly connected, and isConnected[i][j] = 0 otherwise.
 * <p>
 * Return the total number of provinces.
 *
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * Output: 2
 *
 *Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 */

public class NoOfProvinces {

    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(noOfProvinces(isConnected));
    }

    public static int noOfProvinces(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(isConnected, i, visited);
            }
        }
        return provinces;
    }

    private static void bfs(int[][] isConnected, int sourceCity, boolean[] visited) {
        int n = isConnected.length;
        Queue<Integer> queue = new ArrayDeque<>();
        visited[sourceCity] = true;
        queue.add(sourceCity);

        while (!queue.isEmpty()) {
            int currentCity = queue.poll();
            for (int neighbourCity = 0; neighbourCity < n; neighbourCity++) {
                if (isConnected[currentCity][neighbourCity] == 1 && !visited[neighbourCity]) {
                    visited[neighbourCity] = true;
                    queue.add(neighbourCity);
                }
            }

        }
    }


    private static void dfs(int[][] isConnected, int sourceCity, boolean[] visited) {
        visited[sourceCity] = true;

        for (int neighbourCity = 0; neighbourCity < isConnected.length; neighbourCity++) {
            if (isConnected[sourceCity][neighbourCity] == 1 && !visited[neighbourCity]) {
                dfs(isConnected, neighbourCity, visited);
            }
        }
    }
}
