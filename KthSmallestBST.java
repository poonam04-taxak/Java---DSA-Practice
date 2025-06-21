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

public class KthSmallestBST {
    public static void main(String[] args) {
        /*
               5
              / \
             3   6
            / \
           2   4
          /
         1
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        int k = 3; // 3rd smallest

        Solution sol = new Solution();
        int result = sol.kthSmallest(root, k);

        System.out.println("Kth Smallest Element (k = " + k + "): " + result);

        System.out.print("Inorder Traversal: ");
        inorderPrint(root); // for confirmation
    }

    // Inorder traversal print
    public static void inorderPrint(TreeNode root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }
}

// ✅ Solution using Inorder Traversal
class Solution {
    int count = 0;
    int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inorder(node.right, k);
    }
}

