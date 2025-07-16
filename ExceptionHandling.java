/*public class ExceptionHandling {
    public static void main(String[] args) {
        try{
            int a=9;
            int b=0;
            int c=a/b;
      System.err.println(c);
        }
        catch(ArithmeticException e){
            System.out.println("can not divide by 0 :" + e.getMessage());
        }
        finally{
            System.out.println("hello");
        }
    }
}*/
public class ExceptionHandling{
static void validage(int age) throws Exception{
if(age<18){
throw new Exception("you are not valid");
}
else{
System.out.println("you are eligible");
}
} 
public static void main(String args[]){
 try{
 validage(16);
 }
 catch(Exception e){
 System.out.println(e.getMessage());
 }
 }
} 