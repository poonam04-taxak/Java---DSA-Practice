import java.util.*;
public class FindItineraryFromTickets {
    public static String getStart(HashMap<String,String> tick){
        //first step-> find start
        //make a reverse hashmap taki hm from se from ki key ko compare kr ske 
        HashMap<String,String> revMap=new HashMap<>();

        for(String key : tick.keySet()){
            //key->key;val->tick.get(key)
        revMap.put(tick.get(key),key);//phle wale ki key ki value rev k value k equal hogi or phle wale value ki value rev k key k equal hogi
        }
        for(String key:tick.keySet()){
            //check this key exist or not in rev if not exist than it is our start point
            if(!revMap.containsKey(key)){
                return key;
            }
        }
        return null;//if exist 
    }
public static void main(String[] args) {
    HashMap<String,String> tickets=new HashMap<>();
    tickets.put("chennai","bengalurur");
    tickets.put("mumbai","delhi");
    tickets.put("goa","chennai");
    tickets.put("delhi","goa");
  String start=getStart(tickets);

  while(tickets.containsKey(start)){
    System.out.print(start + "->");
   start=tickets.get(start);//update start phle mumbai tha fir delhi....hr ak ko start bnatye jangye fir end 
  }
System.out.println(start);

}    
}
