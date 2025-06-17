public class MergeSort {
    public static void mergeSort(int[] arr,int start,int end){
        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        
        //sort left part
        mergeSort(arr,start,mid);

        //sort right half
        mergeSort(arr,mid+1,end);

        //merge sorted parts
        merge(arr,start,mid,end);
    }
     //function to merge two sorted subarrays
     public static void merge(int[]arr,int start,int mid,int end){
        int[]temp=new int[end-start+1];
        int i=start;
        int j=mid+1;
        int k=0;

        //compare and copy small ele to temp
        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){
                temp[k++]=arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }

        //copy remaning ele to half part
        while(i<=mid){
            temp[k++]=arr[i++];
        }

        //copy rigth
        while(j<=end){
            temp[k++]=arr[j++];
        }
        for(int x=0;x<temp.length;x++){
           arr[start+x]=temp[x]; 
        }
    }   
    
    public static void main(String[] args) {
        int[] arr={5,2,4,7,1,3};
        mergeSort(arr,0,arr.length-1);
        System.out.println("sorted array");
        for(int num:arr)
{
    System.out.println(num);
}
    
}
}
