 class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class KthLevelOfTree {

    // Function to print nodes at kth level
    public static void printKthLevel(TreeNode root, int k) {
        if (root == null) return;

        if (k == 1) {
            System.out.print(root.val + " ");
            return;
        }

        printKthLevel(root.left, k - 1);
        printKthLevel(root.right, k - 1);
    }

    public static void main(String[] args) {
        // Tree structure:
        //        1
        //       / \
        //      2   3
        //     / \   \
        //    4   5   6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        int k = 3;
        System.out.print("Nodes at level " + k + ": ");
        printKthLevel(root, k);  // Output: 4 5 6
    }
}
     

