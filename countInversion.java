public class countInversion {
    public static int mergeSortAndCount(int[]arr,int start,int end){
        int count=0;
        if(start<end){
      int mid=start+(end-start)/2;

      count+=mergeSortAndCount(arr,start,mid);
      count+=mergeSortAndCount(arr,mid+1,end);
      count+=mergeAndCount(arr,start,mid,end);

        }
        return count;
    }
    public static int mergeAndCount(int[]arr,int start,int mid,int end){
        int[] temp=new int[end-start+1];
        int i=start;
        int j=mid+1;
        int k=0;
        int Invcount=0;

        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
                }
            else{
                temp[k++]=arr[j++];
                
                Invcount+=(mid-i+1);//count inversion
            }
        }
         while(i<=mid){
            temp[k++]=arr[i++];
            
         }
         while(j<=end){
            temp[k++]=arr[j++];
         }
         for(int indx=0;indx<temp.length;indx++){
                arr[indx+start]=temp[indx];
         }
         return Invcount;
    }
    public static void main(String[] args) {
        int[] arr={8,4,2,1,0};
        int result=mergeSortAndCount(arr,0,arr.length-1);
        System.out.println("total inversions "+result);
    }
    
}
