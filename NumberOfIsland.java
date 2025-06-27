/*✅ Why DFS is used here?
DFS:

Recursively covers all connected land quickly.

Mark visited without extra space using in-place '0'.

Efficient and simple for matrix-based connectivity problems.

 */
//import java.util.*;

public class NumberOfIsland{
    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        Solution sol = new Solution();
        int result = sol.numIslands(grid);

        System.out.println("Total number of islands: " + result);
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols]; // visited matrix
        int count = 0;

        // Traverse each cell
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    count++;
                    dfs(grid, visited, r, c);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int r, int c) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Base Cases
        if (r < 0 || r >= rows || c < 0 || c >= cols) return; // out of bounds
        if (grid[r][c] == '0' || visited[r][c]) return;        // water or visited

        visited[r][c] = true; // mark visited

        // Explore 4 directions
        dfs(grid, visited, r + 1, c); // down
        dfs(grid, visited, r - 1, c); // up
        dfs(grid, visited, r, c + 1); // right
        dfs(grid, visited, r, c - 1); // left
    }
}
