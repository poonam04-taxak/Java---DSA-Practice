
//package dsa_by_chatgpt;

public class max_in_array {
    public static void main(String[] args) {
        int[] arr = {23,45,67,80,12};
        int max= arr[0];//man lo ism phla hi ele max h
     
      for(int i =0; i<arr.length;i++){
        if(arr[i]>max){
            max=arr[i];//new max number
        }
      }
      System.out.print(max + " ");
    }
    
}
