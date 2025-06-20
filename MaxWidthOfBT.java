 import java.util.*;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// Helper Pair class to store node and its index
class Pair {
    TreeNode node;
    int indx;
    Pair(TreeNode node, int indx) {
        this.node = node;
        this.indx = indx;
    }
}

// Solution class with method to compute max width
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0)); // root has index 0

        while (!q.isEmpty()) {
            int size = q.size();
            int minIndx = q.peek().indx; // base index to avoid overflow
            int start = 0, end = 0;

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                TreeNode node = p.node;
                int indx = p.indx - minIndx; // normalize index

                if (i == 0) start = indx;
                if (i == size - 1) end = indx;

                if (node.left != null)
                    q.offer(new Pair(node.left, 2 * indx));
                if (node.right != null)
                    q.offer(new Pair(node.right, 2 * indx + 1));
            }

            maxWidth = Math.max(maxWidth, end - start + 1);
        }

        return maxWidth;
    }
}

// Main class to test the solution
public class MaxWidthOfBT {
    public static void main(String[] args) {
        // Construct the tree: [1, 3, 2, 5, 3, null, 9]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        // Call the solution
        Solution sol = new Solution();
        int maxWidth = sol.widthOfBinaryTree(root);

        // Print result
        System.out.println("Maximum Width of Binary Tree: " + maxWidth);
    }
}
 