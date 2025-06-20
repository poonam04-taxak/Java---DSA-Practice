import java.util.*;

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

class Solution {
    int postIdx;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;

        // Step 1: Create value → index map for inorder
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Step 2: Build the tree recursively
        return build(postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int start, int end) {
        if (start > end) return null;

        int rootVal = postorder[postIdx--];
        TreeNode root = new TreeNode(rootVal);

        int index = inorderMap.get(rootVal);

        // Build right subtree before left (postorder = left, right, root)
        root.right = build(postorder, index + 1, end);
        root.left = build(postorder, start, index - 1);

        return root;
    }
}

public class BuildTFromInAndPost {
    // Print inorder to verify the tree
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        Solution sol = new Solution();
        TreeNode root = sol.buildTree(inorder, postorder);

        System.out.print("Inorder of constructed tree: ");
        printInorder(root);  // Output: 9 3 15 20 7
    }
}
