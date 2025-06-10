
class Node {
    int data;
    Node next;

    Node(int data){
       this. data=data;
        this.next=null;
    }
}
public class LinkedList{
    Node head;

    //traversal method
    public void display(){
        Node temp=head;
        if(temp==null){
            System.out.println("list is empty: ");
        return;
            }
        while(temp!=null){
            System.out.print(temp.data + " -> ");
            temp=temp.next;
        }    
        System.out.println("null");


}

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new Node(10);//ak node obj bnata h
        ll.head.next =new Node(20);
        ll.head.next.next = new Node(30);

        ll.display();
    }
    
}
