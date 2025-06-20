import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }

}
class Vertical{
    // Tuple class to store node, row, and column
    static class Tuple {
        TreeNode node;
        int row;
        int col;
        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // TreeMap to maintain vertical order (column-wise sorting)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        // Start BFS with root at row = 0, col = 0
        q.add(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple curr = q.poll();
            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;

            // Place node in map[col][row]
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());
            map.get(col).get(row).add(node.val);

            // Add children to queue
            if (node.left != null) {
                q.add(new Tuple(node.left, row + 1, col - 1));
            }
            if (node.right != null) {
                q.add(new Tuple(node.right, row + 1, col + 1));
            }
        }

        // Prepare final result
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            result.add(colList);
        }

        return result;
    }
}

public class VerticalView{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Vertical sol = new Vertical();
        List<List<Integer>> result = sol.verticalTraversal(root);
        System.out.println(result);  // Output: [[9], [3, 15], [20], [7]]
    }
}