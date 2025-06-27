
    import java.util.*;

public class  RottenOrange {
    public static void main(String[] args) {
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };

        Solution sol = new Solution();
        int result = sol.orangesRotting(grid);

        System.out.println("Minimum minutes to rot all oranges: " + result);
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return -1;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Step 1: Count fresh oranges & add initial rotten oranges to queue
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(grid[r][c] == 2) {
                    q.add(new int[]{r, c});
                } else if(grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0; // no fresh oranges to rot

        int minutes = -1; // start from -1 since first iteration will increment it to 0
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        while(!q.isEmpty()) {
            int size = q.size();
            minutes++; // each level in BFS = 1 minute

            for(int i = 0; i < size; i++) {
                int[] point = q.poll();
                int r = point[0];
                int c = point[1];

                for(int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;       // rot the fresh orange
                        q.add(new int[]{nr, nc}); // add newly rotten orange to queue
                        fresh--;                 // decrease fresh count
                    }
                }
            }
        }

        return (fresh == 0) ? minutes : -1;
    }
}