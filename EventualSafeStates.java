
import java.util.*;

public class EventualSafeStates {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] graph = {
            {1, 2},
            {2, 3},
            {5},
            {0},
            {5},
            {},
            {}
        };

        List<Integer> safeNodes = sol.eventualSafeNodes(graph);
        System.out.println("Safe Nodes: " + safeNodes);
    }
}

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n]; // 0: unvisited, 1: visiting, 2: safe
        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!hasCycle(graph, state, i)) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean hasCycle(int[][] graph, int[] state, int node) {
        if (state[node] == 1) {
            return true; // cycle detected
        }
        if (state[node] == 2) {
            return false; // already safe
        }

        state[node] = 1; // mark visiting

        for (int neighbor : graph[node]) {
            if (hasCycle(graph, state, neighbor)) {
                return true; // cycle detected in neighbor
            }
        }

        state[node] = 2; // mark safe
        return false; // no cycle
    }
}
/*Processing:
🔸 Node 0:
DFS on 0:

Visiting → state[0] = 1

neighbors: 1, 2

🔸 DFS on 1:
Visiting → state[1] = 1

neighbors: 2, 3

🔸 DFS on 2:
Visiting → state[2] = 1

neighbors: 5

🔸 DFS on 5:
Visiting → state[5] = 1

No neighbors → state[5] = 2 (safe)

Back to 2:

All neighbors safe → state[2] = 2 (safe)

Back to 1:

🔸 DFS on 3:
Visiting → state[3] = 1

neighbor: 0

DFS on 0 again:
state[0] = 1 already → cycle detected.

Backtrack:

Cycle in 3 → unsafe

Cycle in 1 → unsafe

Cycle in 0 → unsafe

🔸 Node 4:
Visiting → state[4] = 1

neighbor: 5

5 is safe → state[4] = 2 (safe)

🔸 Node 6:
No neighbors → state[6] = 2 (safe)

✅ Final Safe Nodes:
state = [1, 1, 2, 1, 2, 2, 2]

Jinke state 2 hain: 2, 4, 5, 6.

✅ Output:

less
Copy code
Safe Nodes: [2, 4, 5, 6] */