//Array: [5, 15, 25]
//Element to insert: 50
//Position: 5
import java.util.Scanner;
public class insertion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[6];
        int size=5;

        //input array
        System.out.print("enter your array elements: ");
        for(int i=0;i<arr.length;i++){
         arr[i]=sc.nextInt();
        }
       System.out.println("enter that element you want to insert: ");
       int ele=sc.nextInt();
       System.out.println("enter the index of element where you want to insert: ");
       int index=sc.nextInt();

       //left shift one by one
       for(int i=size;i>index;i--){
        arr[i]=arr[i-1];
       }
        arr[index]=ele;
        size++;

        //print updated array
        System.out.println("array after insertion: ");
        for(int i=0;i<arr.length;i++){
            System.out.println( arr[i]  + " ");
        }
        sc.close();
    }
}
