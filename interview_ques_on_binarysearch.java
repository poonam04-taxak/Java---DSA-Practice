// Find First and Last Occurrence of a Number
//Input: arr = {5, 7, 7, 8, 8, 10}, target = 8
//Output: First = 3, Last = 4
// Why not (start + end) / 2?
//→ Because that can cause integer overflow when start + end is large.
//Isiliye safe formula: start + (end - start)/2
public class interview_ques_on_binarysearch {
     public static int findfirst(int[] arr,int target){
      int start=0;
 
      int end=arr.length-1;
      int first=-1;
      while(start<=end){
        int mid=start+(end-start)/2;
        if(arr[mid]==target){
          first=mid;
          end=mid-1;        //end = mid - 1 → left side jaate hain to see if same element pehle bhi milta hai.
      }
      else if(arr[mid]<target){
        start=mid+1;//Mid chhota hai → Right jao.
      }
      else{
        end=mid-1;//Mid bada hai → Left jao. 
        }
     }
     return first;
    }


    public static int findlast(int[]arr,int target){
      int start=0;
      int end=arr.length-1;
      int last=-1;
      while(start<=end){
        int mid=start+(end-start)/2;
        if(arr[mid]==target){
          last=mid;
          start=mid+1;

        }
        else if(arr[mid]<target){
          start=mid+1;
        }
        else{
          end=mid-1;
        }
      }
      return last;
    }
  public static void main(String[] args) {
    int[] arr={5,7,7,8,8,10};
    int target=8;
    int first = findfirst(arr,target);
    int last = findlast(arr,target);
    if(first==-1 || last==-1){
      System.out.println("element not found");
    }
    else{
      System.out.println("element found at first occurrence " +first);
      System.out.println("element found at last occurrence " +last);
    }
}
}