package datastructures.graphs.graph_programs;

import java.util.*;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of
 * islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 * <p>
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 */

// Class to count the number of islands in a grid using BFS
public class NumberOfIslands {

    // Constant array for 4-directional movement (up, down, left, right)
 //   private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Constant array for 4-directional movement (up, down, left, right)
    private static final int[][] DIRECTIONS = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1},    // 4-way
            {-1, -1}, {-1, 1}, {1, -1}, {1, 1}      // + 4 diagonal
    };

    // Counts the number of islands in the given grid
    public static int countIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rowCount = grid.length;
        int columnCount = grid[0].length;
        int islandCount = 0;

        // Iterate through each cell in the grid
        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                if (grid[row][column] == '1') { // Found a new island
                    islandCount++;
                    sinkIslandUsingBFS(grid, row, column);
                }
            }
        }
        return islandCount;
    }

    // Uses BFS to mark all connected land cells ('1') as visited ('0')
    private static void sinkIslandUsingBFS(char[][] grid, int startRow, int startColumn) {
        int rowCount = grid.length;
        int columnCount = grid[0].length;

        // Queue to store cells to explore
        Queue<int[]> queue = new ArrayDeque<>();
        grid[startRow][startColumn] = '0'; // Sink the starting land cell
        queue.add(new int[]{startRow, startColumn});

        // Process cells in the queue
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int column = cell[1];

            // Check all 4 directions for adjacent land cells
            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newColumn = column + direction[1];

                // If the new cell is valid and is a land cell, sink it and add to queue
                if (newRow >= 0 && newRow < rowCount &&
                        newColumn >= 0 && newColumn < columnCount &&
                        grid[newRow][newColumn] == '1') {
                    grid[newRow][newColumn] = '0'; // Sink the land cell
                    queue.add(new int[]{newRow, newColumn});
                }
            }
        }
    }

    // Main method for testing the island counting functionality
    public static void main(String[] args) {
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println("Number of islands in grid1: " + countIslands(grid1)); // Output: 1

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands in grid2: " + countIslands(grid2)); // Output: 3
    }
}
