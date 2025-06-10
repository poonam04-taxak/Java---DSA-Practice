//Array sorted hona chahiye (increasing ya decreasing)

//Hum search space ko har step me aadha karte hain

//time Complexity: O(log n) (Very fast!)


//Find the index of an element in a sorted array

public class binarysearch {
    public static int binarysearch(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            int mid=start + (end-start) /2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;//not found
    }
    public static void main(String[] args) {
        int[] arr={2,3,4,5,6,7,8};
        int target=5;
        int result=binarysearch(arr,target);
    if(result==-1){
        System.out.println("element not found");
    }
    else{
        System.out.println("element found at index: " + result);
    }
    }

    
}
