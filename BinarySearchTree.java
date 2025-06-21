import java.util.*;
public class BinarySearchTree {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }
        public static Node insert(Node root,int valu){
            if(root==null){
                root=new Node(valu);
                return root;
            }
            if(root.data>valu){
                root.left=insert(root.left,valu);
            }
            else{
                root.right=insert(root.right,valu);
            }
            return root;
        }

        public static void inorder(Node root){
            if(root==null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        //search a key in bst
        public static boolean search(Node root,int key){
            if(root==null){
                return false;
            }
            if(root.data>key){
                //leftsubroot
                return search(root.left,key); 
            }
            else if(root.data==key){
                return true;
            }
            else{
                return search(root.right,key);
            }
        }

        //delete a node

        public static Node delete(Node root,int val){
            if(root.data>val){
                root.left=delete(root.left,val);

            }
            else if(root.data<val){
                root.right=delete(root.right,val);
            }
            else{
                //root.data==val
                //case 1:
                if(root.left==null && root.right==null){
                    return null;
                }
                //case 2:
                if(root.left==null){
                    return root.right;
                }
                //case 3:
                Node IS =inordersuccessor(root.right);
                root.data=IS.data;
                root.right=delete(root.right,IS.data);

            }
            return root;
        }
    
        public static Node inordersuccessor(Node root){
            while(root.left!=null){
                root=root.left;
            }
            return root;
        }

        //ques:print a range 

        public static void printInRange(Node root,int x,int y){
            if(root==null){
                return;
            }
            if(root.data>=x && root.data<=y){
                printInRange(root.left,x,y);
                System.out.print(root.data + " ");
                printInRange(root.right,x,y);
            }
            else if(root.data>=y){
                printInRange(root.left,x,y);
            }
            else{
                printInRange(root.right,x,y);
            }
        }

        //ques2:print root to leaf path
        public static void printPath(ArrayList<Integer>path){
            for(int i=0;i<path.size();i++){
                System.out.print(path.get(i) + "->");
            }
            System.out.println();
        }

        public static void printRoot2Leaf(Node root,ArrayList<Integer>path){
            if(root==null){
                return;
            }
            path.add(root.data);

            //leaf
            if(root.left==null && root.right==null){
                printPath(path);
            }
            else{
                //non leaf
                printRoot2Leaf(root.left,path);
                printRoot2Leaf(root.right,path);
            }
            path.remove(path.size()-1);
        }
    public static void main(String[] args) {
        int[] valu={5,6,7,3,2,8};
        Node root=null;

        for(int i=0;i<valu.length;i++){
            root=insert(root,valu[i]);
        }
        inorder(root);
        System.out.println();

    //    if(search(root,9)){
      //      System.out.println("found");
        //}
        //else{
          //  System.out.println("not found");
        //}

       // delete(root,7);
        //inorder(root);
   //    printInRange(root,3,7);
      printRoot2Leaf(root,new ArrayList<>());    
}

}
