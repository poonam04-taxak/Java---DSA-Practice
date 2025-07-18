import java.util.*;
public class MaxEleInArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter size of array");
        int n=sc.nextInt();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();

        }
        int max=arr[0];
        for(int i=1;i<arr.length;i++){

        if(max<arr[i]){
         max=arr[i];
        
        }
    }
        System.out.println(max);
        
    }
}
