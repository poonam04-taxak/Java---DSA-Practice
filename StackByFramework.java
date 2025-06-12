import java.util.Stack;
public class StackByFramework {
    public static void pushAtBottom(int data, Stack<Integer> s){
    if(s.isEmpty()){
        s.push(data);
        return;
    }
    int top=s.pop();
    pushAtBottom(data,s); //jo ele 4 insert krna h top p
    s.push(top);//sare bachye hye ele push after 4
    }
    
    //reverse a stack
    public static void reverse(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int top =s.pop();
        reverse(s);
        pushAtBottom(top,s);
    }
    public static void main(String[] args) {
        
    
    Stack<Integer> s =new Stack<>();
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);

   // pushAtBottom(9,s);
  reverse(s);
    while(!s.isEmpty()){
        System.out.println(s.peek());
        s.pop();
    }

}
}

//1,2,3,4,5 ye push fir  pop krtey to ye 5,4,3,2,1 aata ab ye reverse hoga to 1,2,,3,4,5