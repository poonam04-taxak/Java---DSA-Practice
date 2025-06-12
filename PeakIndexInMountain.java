public class PeakIndexInMountain {
    public static int findpeak(int[] arr){
        int start =0;
        int end = arr.length-1;

        while(start<end){
            int mid=start+(end-start)/2;

            if(arr[mid]<arr[mid+1]){
                // You're in the increasing part
                start=mid+1;
            }
            else{
                end=mid;// You're in the decreasing part or at the peak:     arr[mid] >= arr[mid + 1]
                                                       //Yahan do possibilities ho sakti hain:
                                                                   //arr[mid] > arr[mid + 1]
                                                                   //→ aap decreasing slope me ho
                                                       //→ peak aapke left ya yahi mid pe ho sakta hai
                                                         //✅ isiliye end = mid;

                                                             //arr[mid] == arr[mid + 1]
                                                                //→ plateau (flat) situation ho sakti hai
                                                              //→ Still, peak can be on left or at mid
                                                                  //✅ tab bhi end = mid;
            }
        }
        return start;// start == end, that's the peak

    }
    public static void main(String[] args) {
        int[] arr ={1, 3, 5, 6, 4, 2};
        int peakindex=findpeak(arr);
        System.out.println("peak ele index: " +peakindex);
        System.out.println("peak ele value: " + arr[peakindex]);

    }
    
}
