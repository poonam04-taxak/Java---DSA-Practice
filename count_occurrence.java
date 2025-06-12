//🧠 Interview Tip:
//Aap se interviewer pooch sakta hai:

//"How would you count frequency of an element in O(log n)?"

//Tum confidently bolna:

//"Using Binary Search twice – once for first index, once for last. Then last - first + 1."


public class count_occurrence{
    public static int firstocc(int[] arr,int target){
        int start =0;
        int end=arr.length-1;
        int first = -1; //yani ele h hi nhi array m

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid]==target){
                first=mid;
                end = mid-1;
            }
            else if(target>arr[mid]){
                start=mid+1;

            }
            else{
                end = mid-1;
            }
        }
        return first;
    }

    public static int lastocc(int[] arr, int target){
        int start =0;
        int end=arr.length-1;
        int last = -1;

        while(start<=end){
            int mid =start+(end-start)/2;

             if(arr[mid]==target){
                last=mid;
                start= mid+1;
            }
            else if(target>arr[mid]){
                start=mid+1;

            }
            else{
                end=mid-1;
            }
            
        }
        return last;
    }
    public static void main(String args[]){
        int[] arr = {1,2,2,2,3,4,5};
        int target = 2;

     int first =   firstocc(arr,target);
        int last = lastocc(arr,target); //Yeh function array mein aakhri baar target kaha mila uska index return karta hai.

        if(first==-1){
            System.out.println("target not found");
        }
        else{
            int count = last-first+1;
            System.out.println(count);//Hum +1 isliye karte hain kyunki indexing 0 se start hoti hai.
        }


    }
}