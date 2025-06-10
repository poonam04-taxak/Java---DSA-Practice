public class linearsearch{
    public static void main(String[] args) {
        int[] arr = {14,5,7,8,0};
        int target =7;
        boolean flag=false; //flag is a simple variable of boolean type.it tell us that work has happen or not or condition is true or false
   //we assume that target is not found
  for(int i=0;i<arr.length;i++){
    if(arr[i]==target){
        flag=true;
        System.out.println("element found at" + i);//arr[i]=value dega 7 pr i index btayega
        break;
    
    }
  } 
  if(!flag){
    System.out.println("element not found");
  }
    }
}