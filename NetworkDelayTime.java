
import java.util.*;

public class NetworkDelayTime {

    public static int networkDelayTime(int[][] times, int n, int k) {
        // Graph creation: Adjacency list where graph[u] contains [v, weight]
        List<int[]>[] graph = new ArrayList[n + 1]; // 1-based indexing
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : times) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph[u].add(new int[]{v, w});
        }

        // Min-Heap: Stores [time, node]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k}); // Start with time = 0, node = k

        boolean[] visited = new boolean[n + 1];
        int res = 0; // To store max time taken to reach any node

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            if (visited[node]) continue; // Skip if already visited

            visited[node] = true; // Mark as visited
            res = Math.max(res, time); // Update result as max time seen so far

            // Visit all neighbors
            for (int[] nei : graph[node]) {
                int nextNode = nei[0];
                int wt = nei[1];
                if (!visited[nextNode]) {
                    pq.offer(new int[]{time + wt, nextNode}); // Add to heap with updated time
                }
            }
        }

        // Check if all nodes were visited
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return -1; // Some nodes are unreachable
            }
        }
        return res; // Time for the signal to reach all nodes
    }

    public static void main(String[] args) {
        int[][] times = {
            {2, 1, 1},
            {2, 3, 1},
            {3, 4, 1}
        };
        int n = 4; // number of nodes
        int k = 2; // starting node

        int result = networkDelayTime(times, n, k);
        System.out.println("Network Delay Time: " + result);
    }
}
