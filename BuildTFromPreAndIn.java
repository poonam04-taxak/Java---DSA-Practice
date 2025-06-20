/*🔶 Why use HashMap?
In previous method:

In every recursive call, we search root's index in inorder using a for loop.

That takes O(n) time each time.

So total = O(n²) time complexity ❌

✅ HashMap Solution:
We will create a Map<Integer, Integer> to store value-to-index for inorder array.

So instead of searching linearly in inorder[], we get index in O(1) time.

 */
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class BuildTFromPreAndIn{
    static int preorderIndex = 0;
    static Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // Step 1: Fill HashMap with value -> index from inorder
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    public static TreeNode build(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inorderIndexMap.get(rootVal); // O(1) index find

        // Recursively build left and right subtrees
        root.left = build(preorder, inStart, inIndex - 1);
        root.right = build(preorder, inIndex + 1, inEnd);

        return root;
    }

    // To test: print inorder of tree
    public static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);

        System.out.print("Inorder of constructed tree: ");
        printInorder(root);  // Should print: 9 3 15 20 7
    }
}
 
