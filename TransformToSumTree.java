import java.util.*;
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    // Helper function to convert tree to sum tree
    public int toSumTree(TreeNode root) {
        if (root == null) return 0;

        // Recurse left and right
        int leftSum = toSumTree(root.left);
        int rightSum = toSumTree(root.right);

        int oldVal = root.val;

        // Set current node's value to sum of left + right
        root.val = leftSum + rightSum;

        // Return total sum including old value
        return root.val + oldVal;
    }

    public void transform(TreeNode root) {
        toSumTree(root);
    }
}
 
public class TransformToSumTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(-4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);

        Solution sol = new Solution();
        sol.transform(root);  // Transform to sum tree

        System.out.print("Level Order of Sum Tree: ");
        printLevelOrder(root);  // Output should be: 20 4 12 0 0 0 0
    }

    public static void printLevelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }
}
