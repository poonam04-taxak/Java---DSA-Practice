import java.util.HashSet;

public class RemoveDuplicates {
    public static void remove(int[] arr){
        HashSet<Integer>set=new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
    for(int num:set){
        System.out.println(num);
    }
    }
    public static void main(String[] args) {
        int[] arr={1,2,4,2,6,7,6};
        
    remove(arr);
    }
}
