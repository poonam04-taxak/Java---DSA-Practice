

/*public class else_if {
    public static void main(String[] args) {
        int age=30;
        if(age>=50){
            System.out.println("you are experienced person 1!");
        }
        else if(age>40){
            System.out.println("you are semi experienced!");
        }
        else if(age>30){
            System.out.println("you are semi semi experienced person!");
        }
        else{
            System.out.println("sorry!you are not experienced!");
        }
    }
    
} */



import java.util.Scanner;
class else_if{
    public static void main(String[] args) {
        System.out.println("enter your age:");
        Scanner sc = new Scanner(System.in);
        int age=sc.nextInt();
        if(age>50){
            System.out.println("you are experienced person");
        }
        else if(age>40){
            System.out.println("you are semi experienced");
        }
        else{
            System.out.println("sorry you are not experienced");
        }
        sc.close();
    }
}
