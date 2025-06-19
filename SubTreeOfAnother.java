public class SubTreeOfAnother {


    // Node class for tree
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // check if subRoot is a subtree of root
    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) return false;

        if (isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // check if two trees are identical
    public static boolean isSameTree(Node s, Node t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (s.data != t.data) return false;

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    // main function
    public static void main(String[] args) {

        // main tree
        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(2);

        // subtree
        Node subRoot = new Node(4);
        subRoot.left = new Node(1);
        subRoot.right = new Node(2);

        // check
        if (isSubtree(root, subRoot)) {
            System.out.println("Yes, it is a subtree.");
        } else {
            System.out.println("No, it's not a subtree.");
        }
    }
}

    
