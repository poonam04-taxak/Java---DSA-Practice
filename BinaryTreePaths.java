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

// Solution class
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) return;

        // Build current path
        if (path.isEmpty()) {
            path += node.val;
        } else {
            path += "->" + node.val;
        }

        // If leaf node, add path to result
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        // Recurse left and right
        dfs(node.left, path, result);
        dfs(node.right, path, result);
    }
}

// Driver code to test
public class BinaryTreePaths {
    public static void main(String[] args) {
        // Build sample tree: [1, 2, 3, null, 5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        Solution sol = new Solution();
        List<String> paths = sol.binaryTreePaths(root);

        System.out.println("Binary Tree Paths:");
        for (String path : paths) {
            System.out.println(path);
        }
    }
}
 
