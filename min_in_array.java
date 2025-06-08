

public class min_in_array {
    public static void main(String[] args) {
        int[] arr = {23,45,67,89,10};
        int min = arr[0];//man liya phla ele hi min h
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println(min + " ");
    }
}
