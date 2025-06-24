import java.util.*;
public class MajorityEle {
   public static void ele(int nums[]){
    //step 1-> create hashmap
    HashMap<Integer,Integer> map =  new HashMap<>();
   
//step 2->create pair of key and value with th for loop
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){ // key exist than add its frequecy
                map.put(nums[i],map.get(nums[i])+1);//update the frequency
            }
            else{
                //key not exist phle se nhi h to add krenge key m or frequency 1 ho jayegi
                map.put(nums[i],1);
            } 
        }

        //step 3->check ele majority
        for(int key : map.keySet()){
            if(map.get(key)>n/3){
                System.err.println(key);
            }
        }
}

    public static void main(String[] args) {
        int nums[]={1,3,2,5,3,1,5,1};

        ele(nums);
    }
}
