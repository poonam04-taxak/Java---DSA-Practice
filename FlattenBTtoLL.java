
// TreeNode class
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

// Solution class to flatten the tree
class Solution {
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        // Reverse Preorder: right → left → root
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}

// Main class to test the flatten function
public class FlattenBTtoLL {
    public static void main(String[] args) {
        /*
         Build the tree:
                 1
                / \
               2   5
              / \   \
             3   4   6
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        Solution sol = new Solution();
        sol.flatten(root);

        // Print the flattened tree
        TreeNode curr = root;
        System.out.println("Flattened Tree:");
        while (curr != null) {
            System.out.print(curr.val + " ->");
            curr = curr.right;
        }
    }
}
 
