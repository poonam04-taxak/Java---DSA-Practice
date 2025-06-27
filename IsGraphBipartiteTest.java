
 import java.util.Arrays;

public class IsGraphBipartiteTest {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test graph (even cycle, bipartite)
        int[][] graph = {
            {1, 3},   // Node 0 connected to 1, 3
            {0, 2},   // Node 1 connected to 0, 2
            {1, 3},   // Node 2 connected to 1, 3
            {0, 2}    // Node 3 connected to 0, 2
        };

        boolean result = sol.isBipartite(graph);
        System.out.println("Is Graph Bipartite? " + result);
    }
}

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] col = new int[n];
        Arrays.fill(col, -1); // Initially all nodes uncolored

        for (int i = 0; i < n; i++) {
            if (col[i] == -1) { // Unvisited node
                if (!dfs(graph, col, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] col, int node, int c) {
        col[node] = c; // Color current node

        for (int neigh : graph[node]) {
            if (col[neigh] == -1) { // If neighbor not colored
                if (!dfs(graph, col, neigh, 1 - c)) {
                    return false;
                }
            } else if (col[neigh] == c) { // Neighbor has same color
                return false; // Not bipartite
            }
        }
        return true;
    }
}

