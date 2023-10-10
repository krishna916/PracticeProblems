package com.krishnamurti.gfg.graph.matrix;

// islands can be connected in all directions - horizontally or vertically or diagonally i.e., in all 8 directions.
public class NoOfIslands {
    private static final int[][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0},
            {-1, 1},
            {1, 1},
            {1, -1},
            {-1, -1}
    };


    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    islands++;
                    dfs(i, j , grid, visited);
                }
            }
        }

        return islands;
    }

    private void dfs(int row, int col, char[][] grid, boolean[][] visited) {
        visited[row][col] = true;
        for (int[] direction: directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if ( nextRow >= grid.length || nextRow < 0 ||
                    nextCol >= grid[0].length || nextCol < 0 ||
                    grid[nextRow][nextCol] == '0' || visited[nextRow][nextCol]
            )
            {
                continue;
            }

            dfs(nextRow, nextCol, grid, visited);
        }
    }


    public static void main(String[] args) {
        NoOfIslands o = new NoOfIslands();

        char[][] grid = {
                {'0', '1'}, {'1','0'}, {'1','1'}, {'1', '0'}
        };

        System.out.println(o.numIslands(grid));
    }
}
