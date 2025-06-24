import java.util.HashMap;
//import java.util.Iterator;
public class Hashmap {
    public static void main(String[] args) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("janau khari",03);
        map.put("mehra",15);
       map.put("tiwala",04);
  
  System.out.println(map);

  if(map.containsKey("mehra")){
    System.out.println("yes,this key is present in your map");
  }
  else{
    System.out.println("sorry! this key is not present");
  }
int[] arr={2,3,5,7,8};
for(int i=0;i<arr.length;i++){
    System.out.print(arr[i]);
}
System.out.println();
for(int val:arr){
    System.out.print(val);
}
    }
    
}
