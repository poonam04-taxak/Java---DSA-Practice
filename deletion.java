import java.util.Scanner;
public class deletion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[5];
        int size=5;

        //input array
        System.out.println("enter youre elements that you want to insert: ");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("enter element's index that you want to delete: ");
        int indextodelete =sc.nextInt();
        
        if(indextodelete<0 || indextodelete>=size){
            System.out.println("sorry! we can't delete this ele bcoz it does't exist: ");

        }
        else{
            for(int i=indextodelete;i<size-1;i++){
                arr[i]=arr[i+1];
            }
            size--;
        }
    System.out.println("updated array is: ");
for(int i=0;i<size;i++){
    System.out.println(arr[i] + " ");
}
sc.close();
    }
}
