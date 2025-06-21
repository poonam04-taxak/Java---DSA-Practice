//import java.util.*;

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

public class IsValidBST {

    public static void main(String[] args) {
        // ✅ Example 1: Valid BST
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);

        // ❌ Example 2: Invalid BST
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);

        Solution sol = new Solution();

        System.out.println("Is Tree 1 a valid BST? " + sol.isValidBST(root1));  // true
        System.out.println("Is Tree 2 a valid BST? " + sol.isValidBST(root2));  // false
    }
}

// ✅ Solution class using inorder traversal
class Solution {
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        // Check left
        if (!isValidBST(root.left)) return false;

        // Check current
        if (prev != null && root.val <= prev.val) return false;

        prev = root; // Update previous
        return isValidBST(root.right); // Check right
    }
}
