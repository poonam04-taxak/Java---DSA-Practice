//import java.util.*;

public class NumberOfProvinces {

    // Function to find the number of provinces
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length; // Total number of cities (nodes)
        boolean[] visited = new boolean[n]; // Track visited cities
        int count = 0; // Count of provinces

        // Loop through each city
        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // If the city is not yet visited
                dfs(isConnected, visited, i); // Explore all connected cities using DFS
                count++; // One full connected component (province) found
            }
        }

        return count; // Return total number of provinces
    }

    // DFS to visit all cities in a province
    public static void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true; // Mark current city as visited

        for (int j = 0; j < isConnected.length; j++) {
            // If city `j` is directly connected to current city and not yet visited
            if (isConnected[city][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j); // Recursively visit the connected city
            }
        }
    }

    // ✅ Main function to test
    public static void main(String[] args) {
        // Example input: 3 cities. City 0 connected to 1, city 2 is isolated.
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        // Expected output: 2 provinces -> {0,1} and {2}
        int provinces = findCircleNum(isConnected);
        System.out.println("Number of Provinces: " + provinces);
    }
}
