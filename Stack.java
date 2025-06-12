/*public class Stack{
    static class Node{
        int data;
        Node next;

       public Node(int data){
            this.data = data;
            this.next=null;
        }
    }
    static class StackByLL{
        public static Node head;
        public static boolean isEmpty(){
            return head==null;
        }
        public static void push(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public static int pop(){
        if(isEmpty()){
            return -1;
        }
      int top =head.data;
      head=head.next;
      return top;
    }
    public static int peek(){
        if(isEmpty()){
            return -1;
        }
        return head.data;
    }
        }
    public static void main(String[] args) {
      //  StackByLL s= new StackByLL();
        StackByLL.push(1);
         StackByLL.push(2); 
         StackByLL.push(3);
        StackByLL.push(4);
         StackByLL.push(5);

         while(!StackByLL.isEmpty()){
            System.out.println(StackByLL.peek());
            StackByLL.pop();
         }
    }
}*/



//2nd method 
public class Stack {

    // Node class to define each element in stack
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Stack implemented using Linked List
    static class StackByLL {
        private Node head; // No longer static

        // Check if stack is empty
        public boolean isEmpty() {
            return head == null;
        }

        // Push element on top
        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        // Pop element from top
        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // Peek the top element
        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack is empty!");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        StackByLL s = new StackByLL(); // Now object works

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println("Elements in stack (from top to bottom):");
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}


/*Interview Point:
Why Linked List in Stack?
→ Size dynamic hota hai. Overflow ka issue nahi aata.

Time Complexity:

Push: O(1)

Pop: O(1)

Peek: O(1)

Memory Usage: Thoda zyada hota hai kyunki har element ke saath ek next pointer bhi store hota hai.

*/