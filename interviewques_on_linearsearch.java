/*//Question 1: Count how many times target appears in array by using for loop or by using recursion
public class interviewques_on_linearsearch {
    public static void recursivesearch(int[] arr,int target,int index){
        if(index==arr.length){
            return;
        }
        if(arr[index]==target)
        {
          System.out.println("element found at " + index);
        }
        recursivesearch(arr,target,index+1);
    }
    public static void main(String[] args) {
        int[] arr={2,4,5,6,7,5};
        int target=5;
        recursivesearch(arr,target,0);
        /*int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                count++;
            }
        }
        System.out.println("element found " + count + " times");
    }

    
}*/



//Question 2: Return first and last index of target by using for loop

public class interviewques_on_linearsearch {
    public static void main(String[] args) {
        int[] arr={2,4,6,4,7,4};
        int target=4;
        /*  for(int i=0;i<arr.length;i++){
            if(arr[i]==target){
                System.out.println("element found at index from starting: " + i);
                break;
            }
        }
    }
}
for(int i=arr.length-1;i>=0;i--){
    if(arr[i]==target){
        System.out.println("element found at index from last " + i);

       break;
    }
}
    }
}*/

//combining both condition

int first=-1;
int last=-1;
for(int i=0;i<arr.length;i++){
if(arr[i]==target){
    if(first==-1){
        first=i;
    }
    last=i;
}
}
if(first==-1){
    System.out.println("element not found");
}
else{
    System.out.println("first index: "+first);
    System.out.println("last index "+last);
}
}
}
