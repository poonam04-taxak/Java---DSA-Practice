//Insert at end	O(n)
class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class insertat_begining {
    Node head;
    public void IAB(int data){
        Node newnode=new Node(data);
        newnode.next=head;
        head=newnode;
    }
    public void display(){
        Node temp=head;
        if(temp==null){
            System.out.println("list is empty: ");
            return;
        }
        while(temp!=null){
            System.out.print(temp.data + " ->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    
    public static void main(String args[]){
        insertat_begining ll = new insertat_begining();
        ll.IAB(10);
        ll.IAB(20);
        ll.IAB(30);
        ll.display();
    }
    
}


/*📌 Important Interview Notes:
Point	Description
Time Complexity	O(1) — because koi traversal nahi hota
Space Complexity	O(1) — sirf ek node extra banta hai
Use Case	When you need to maintain insertion in reverse order*/