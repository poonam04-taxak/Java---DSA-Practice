/*public class linearsearch {
    public static void main(String[] args) {
       int[] nums={2,3,5,7,9,10,20,45};
       int target = 20;
       int ans = linearSearch(nums , target);
       System.out.println(ans);
    }

    static int linearSearch(int[] arr,int target){
        if(arr.length ==0){
            return -1;
        }
        for(int index=0;index<arr.length;index++){
            int element = arr[index];
            if(element==target){
                return index;
            }
        }
        return -1;
    }
}




// searching in string 

public class linearsearch{
    public static void main(String args[]){
        int[] arr ={};
        int target = 8;
     int ans = stringsearch(arr,target);
     System.out.println(ans);

    }
    static int stringsearch(int[] num,int target){
        if(num.length==0){
            System.out.println("Sorry you don't have any item in this array");
        }
        for(int index=0;index<num.length;index++){
            int element = num[index];
            if(element==target){
                return index;
            }

        }
        return -1;
    }
}*/



//string 

public class linearsearch{
    public static void main(String args[]){ 
        String arr ="poonam";
        char target='n';
     System.out.println(search(arr,target));
     

    }
 static  boolean search(String str,char target){
    if(str.length()==0){
        return false;

    }
    for(int index=0;index<str.length();index++){
        if(target==str.charAt(index)){
            return true;
        }
    }
    return false;
 }
}
