class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class insertat_end {
    Node head;

    public void insertatend(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
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
    }
    public static void main(String[] args) {
        insertat_end ie=new insertat_end();
        ie.insertatend(20);
        ie.insertatend(30);
        ie.insertatend(40);

        ie.display();
    }
    
}
