// import java.util.*;

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

public class MinDiffBST {
    public static void main(String[] args) {
        /*
              4
             / \
            2   6
           / \
          1   3
        */
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Solution sol = new Solution();
        int result = sol.minDiffInBST(root);

        System.out.println("Minimum difference between any two nodes: " + result);

        System.out.print("Inorder Traversal of BST: ");
        inorderPrint(root);
    }

    // Helper function to print inorder traversal (sorted values)
    public static void inorderPrint(TreeNode root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }
}

// ✅ Solution using inorder traversal
class Solution {
    TreeNode prev = null;
    int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev.val);
        }
        prev = node;

        inorder(node.right);
    }
}
 