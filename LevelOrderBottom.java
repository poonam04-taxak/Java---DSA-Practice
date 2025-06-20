 import java.util.*;

// TreeNode class
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>(); // LinkedList allows add(0, ...)
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            // Traverse current level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            result.add(0, level); // Insert at beginning for bottom-up order
        }

        return result;
    }
}

public class LevelOrderBottom {
    public static void main(String[] args) {
        // Example tree:
        //       3
        //      / \
        //     9  20
        //        / \
        //       15  7

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution sol = new Solution();
        List<List<Integer>> output = sol.levelOrderBottom(root);

        System.out.println("Bottom-up level order traversal:");
        for (List<Integer> level : output) {
            System.out.println(level);
        }
    }
}
     

