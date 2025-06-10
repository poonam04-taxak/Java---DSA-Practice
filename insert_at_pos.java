class node{
    int data;
    node next;

    node(int data){
        this.data=data;
        this.next=null;
    }
}
public class insert_at_pos {
    node head;

    public void insertatpos(int data,int pos){
        node newnode=new node(data);

        //case1=insert at begining
        if(pos==1){
            newnode.next=head;
            head=newnode;
            return;
        }

        //case2.insert at given position
        node temp=head;                                  
/*for (int i = 1; i < pos - 1; i++) {
    if (temp != null) {
        temp = temp.next;
    } else {
        System.out.println("Invalid position");
        return;
    }
}*/
        int count=1;
        while(temp!=null && count<pos-1){
            temp=temp.next;
            count++;
        }
       if(temp==null){
        System.out.println("list is empty: ");
        return;
       }
       newnode.next=temp.next;
       temp.next=newnode;
    }

    //traversal
    public void display(){
        node temp=head;
        if(temp==null){
            System.out.println("list is empty ");
            return;
        }
        while(temp!=null){
            System.out.print(temp.data + " ->");
            temp=temp.next;
        }
        System.out.println("null");

    }

    public static void main(String[] args) {
        insert_at_pos ip = new insert_at_pos();
        ip.insertatpos(10,1);
        ip.insertatpos(20,2);
        ip.insertatpos(30,3);
        ip.insertatpos(40,4);
        ip.insertatpos(50,5);
        ip.insertatpos(60,6);

        ip.display();
        

    }
    
}
