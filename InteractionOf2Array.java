import java.util.*;
public class InteractionOf2Array {

    public static int Interaction(int[] arr1,int[] arr2){
        HashSet<Integer> set=new HashSet<>();
       ArrayList<Integer> common = new ArrayList<>();
        int count=0;
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);//arr1 k sare ele add kr diye set m

        }
        for(int j=0;j<arr2.length;j++){
            if(set.contains(arr2[j])){
                //check krna h ki arr2 ka ele already exist krta h kya set m krta h to match found or remove kr do use set se
                   count++;
                   common.add(arr2[j]);
                   set.remove(arr2[j]);    
                        }
        }
        System.out.println("common ele are: " + common);
        return count;
    }
    

    public static void main(String[] args) {
        int[] arr1={7,3,9};
        int[] arr2={6,3,9,2,9,4};
    
        System.out.println(Interaction(arr1,arr2));
    }
    
}
