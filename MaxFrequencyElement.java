import java.util.*;

public class MaxFrequencyElement {
    public static void max(int[] arr){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else{
                map.put(num,1);
            }
        }
        int maxFreq=0;
        int ele=-1;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>maxFreq){
                maxFreq=entry.getValue();
                ele=entry.getKey();
            }
        }
        System.out.println(ele);
        System.out.println(maxFreq);
        }
    
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,1,2,1,5,1};
max(arr);
    }
}
