import java.util.HashSet;

public class UnionOfTwoArray {
    public static void union(int[] arr1,int[] arr2){
        
        HashSet<Integer> map=new HashSet<>();
        for(int num:arr1){
            map.add(num);
        }
        for(int num:arr2){
            map.add(num);
        }
        System.out.println("union of array:");
        for(int i:map){
            System.out.println(i);
        }
        System.out.println();
    }
   public static void main(String[] args) {
    int[] arr1={9,8,6,9,8};
    int[] arr2={1,2,3,4,5,2,3};
    union(arr1,arr2);
   } 
}
