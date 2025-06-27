import java.util.ArrayList;
import java.util.Scanner;

public class CourseScheduleDFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of courses
        System.out.print("Enter number of courses: ");
        int numCourses = sc.nextInt();

        // Input number of prerequisites
        System.out.print("Enter number of prerequisites: ");
        int n = sc.nextInt();
        sc.close();

        int[][] prerequisites = new int[n][2];

        System.out.println("Enter prerequisites (course prerequisite):");
        for (int i = 0; i < n; i++) {
            prerequisites[i][0] = sc.nextInt(); // course
            prerequisites[i][1] = sc.nextInt(); // prerequisite
        }

        Solution sol = new Solution();
        boolean canFinish = sol.canFinish(numCourses, prerequisites);
        System.out.println("Can finish all courses: " + canFinish);
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adjacency list using ArrayList<ArrayList<Integer>>
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];
            adj.get(prerequisite).add(course);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        // Check for cycle from each course
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(adj, visited, recStack, i)) {
                    return false; // cycle detected, cannot finish
                }
            }
        }
        return true; // no cycle, can finish
    }

    private boolean hasCycle(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recStack, int curr) {
        visited[curr] = true;
        recStack[curr] = true;

        for (int neighbor : adj.get(curr)) {
            if (!visited[neighbor]) {
                if (hasCycle(adj, visited, recStack, neighbor)) {
                    return true; // cycle detected
                }
            } else if (recStack[neighbor]) {
                return true; // back edge found, cycle detected
            }
        }

        recStack[curr] = false; // backtrack
        return false;
    }
}

