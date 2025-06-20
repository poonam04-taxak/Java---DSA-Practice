 class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    int preIdx = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] postorder, int postStart, int postEnd) {
        if (preIdx >= preorder.length || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx++]);

        if (postStart == postEnd || preIdx >= preorder.length) {
            return root;  // No child
        }

        // Next preorder element is left child
        int leftVal = preorder[preIdx];
        int leftIndex = postStart;

        // Find left child index in postorder
        while (postorder[leftIndex] != leftVal) {
            leftIndex++;
        }

        // Left subtree size = leftIndex - postStart + 1
        root.left = build(preorder, postorder, postStart, leftIndex);
        root.right = build(preorder, postorder, leftIndex + 1, postEnd - 1);

        return root;
    }
}

public class BuildTFromPreAndPost {
    public static void printPreorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        Solution sol = new Solution();
        TreeNode root = sol.constructFromPrePost(preorder, postorder);

        System.out.print("Preorder of constructed tree: ");
        printPreorder(root); // Output: 1 2 4 5 3 6 7
    }
}
/*import java.util.*;

// TreeNode class
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

// Main solution class
class Solution {
    int preIdx = 0;
    Map<Integer, Integer> postIndexMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        // Step 1: Build value → index map from postorder
        for (int i = 0; i < postorder.length; i++) {
            postIndexMap.put(postorder[i], i);
        }

        // Step 2: Start recursive tree building
        return build(preorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] postorder, int postStart, int postEnd) {
        if (preIdx >= preorder.length || postStart > postEnd) return null;

        TreeNode root = new TreeNode(preorder[preIdx++]);

        // Base case: No children
        if (postStart == postEnd || preIdx >= preorder.length) return root;

        // Find index of left child in postorder
        int leftVal = preorder[preIdx];
        int leftIndex = postIndexMap.get(leftVal);

        // Build left and right subtrees
        root.left = build(preorder, postorder, postStart, leftIndex);
        root.right = build(preorder, postorder, leftIndex + 1, postEnd - 1);

        return root;
    }
}

// Driver class with main()
public class Main {
    // Preorder print to verify result
    public static void printPreorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        Solution sol = new Solution();
        TreeNode root = sol.constructFromPrePost(preorder, postorder);

        System.out.print("Preorder of constructed tree: ");
        printPreorder(root);  // Output: 1 2 4 5 3 6 7
    }
}
 */