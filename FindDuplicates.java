public class FindDuplicates {
    public static boolean find(int[]arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    return true;
                }
                
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr={7,8,4,2,4};
       boolean dup= find(arr);
       System.out.println(dup);
    }
}
