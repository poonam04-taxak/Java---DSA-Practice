import java.util.*;
public class NonRepatingEle {
    public static int ele(int[] arr){
        
        HashMap<Integer,Integer> map=new HashMap<>();
     for(int num:arr){
        if(map.containsKey(num)){
            map.put(num,map.get(num)+1);
          
        }
        else{
            map.put(num,1);
        }
     }
     for(int num:arr){
        if(map.get(num)==1){
            return num;
        }
     }
     return -1;

    }
    public static void main(String[] args) {
        int[] arr={9,4,9,6,7,4};
    int ans=ele(arr);
    System.out.println(ans);
    }
}
