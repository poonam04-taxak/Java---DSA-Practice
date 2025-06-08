/*//by using for each loop
public class reverse_array {
    public static void main(String[] args) {
        int[] arr = {3,4,5,6,7,8,9};
        int i = 0;
        int j = arr.length-1;

        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
        for(int ele : arr){
            System.out.print(ele + " ");
        }

    }
    
}*/



// by using for loop
public class reverse_array{
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        int size = arr.length;
        int[] rev = new int[size];//creat a new array in which we store our reversed array elements
         
    
        for(int i=0;i<size;i++){
            rev[i] = arr[size-1-i];

        }
        //used for printing array
        for(int i=0;i<size;i++){
            System.out.print(rev[i] + " ");
        }
    }
}