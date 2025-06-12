public class search_in_roatedarray {

    public static int search(int[] arr, int target){
        int start =0;
        int end = arr.length-1;

        while(start<=end){
            int mid=start + (end-start)/2;

            if(arr[mid]==target){
                return mid;
            }

            // check if left half is sorted
            if(arr[start]<=arr[mid]){
                //this second if is used to check if target lie or not
                if(target>=arr[start] && target<arr[end]){
                    end=mid-1;
                }
                else {
                        start=mid+1;
                    }
                }
                //otherwise rigth half is sorted
            else {
             if(target>arr[mid] && target<=arr[end]){
                start=mid+1;
             }
             else {
                end=mid-1;
             }

            }

            }  
            return -1;      
                }
        
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target=0;
  
        int result=search(arr,target);
        System.out.println("target found at index: " +result);
    }
    
}
