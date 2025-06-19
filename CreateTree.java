import java.util.Queue;
import java.util.LinkedList;
public class CreateTree{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree{
        static int indx=-1;
        public static Node buildTree(int[]nodes){
       indx++;
       if(nodes[indx]==-1){
        return null;
       }
       Node newNode = new Node(nodes[indx]);
       newNode.left=buildTree(nodes);
       newNode.right=buildTree(nodes);
    return newNode;     
   }
    }

    //preorder traversal (time complixity=o(n))
    public static void preorder(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data +" ");
        preorder(root.left);
        preorder(root.right);
    }

    //inorder(o(n))
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //postorder(o(n))
    public static void postorder(Node root){
        if(root==null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    //level of traversal or BFS

    public static void levelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode=q.remove();
            if(currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.add(null);
                }
            }
            else{
                System.out.print(currNode.data + " ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }

    }

    //count nodes
    public static int countNodes(Node root){
        if(root==null){
            return 0;        
        }
    
    int leftNode=countNodes(root.left);
    int rightNode=countNodes(root.right);
    return leftNode+rightNode+1;
    }

    //count sum of all nodes
    public static int countSum(Node root){
        if(root==null){
            return 0;        
        }
    
    int leftSum=countSum(root.left);
    int rightSum=countSum(root.right);
    return leftSum+rightSum+root.data;
    }

    //height of tree
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        int total = Math.max(leftHeight,rightHeight)+1;
        return total;

    }
    
    //diameter of tree, T.C=O(N^2)
    public static int diameter(Node root){
        if(root==null){
            return 0;
        
        }
        int diam1=diameter(root.left);
        int diam2=diameter(root.right);
        int diam3=height(root.left)+height(root.right)+1;

        return Math.max(diam3,Math.max(diam1,diam2));
    }

    //find diameter by using linear complixity O(N)

    static class TreeInfo{
        int ht;
        int diam;

        TreeInfo(int ht,int diam){
            this.ht=ht;
            this.diam=diam;
        }
    }
        public static TreeInfo diameter2(Node root){
            if(root==null){
                return new TreeInfo(0,0);
            }
            TreeInfo left=diameter2(root.left);
            TreeInfo right=diameter2(root.right);

            int myHt=Math.max(left.ht,right.ht)+1;

            int diam1=left.diam;
            int diam2=right.diam;
            int diam3=left.ht+right.ht+1;

            int mydiam=Math.max(Math.max(diam1,diam2),diam3);
        TreeInfo myinfo = new TreeInfo(myHt,mydiam);
    return myinfo;    
    }


    

    public static void main(String[] args) {
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
    Node root=BinaryTree.buildTree(nodes);
    System.out.println("Root node: "+root.data);
    //preorder(root);
   // inorder(root);
   //postorder(root);
 //  levelOrder(root);
 //System.out.println(countNodes(root));
   
//System.out.println(countSum(root));
//System.out.println(height(root));

//System.out.println(diameter(root));
System.out.println(diameter2(root).diam);
}
}