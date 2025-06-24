import java.util.*;
public class HashMapImplem {
    static class HashMap<K,V>{ //called generics or permitized type, here we don't know the data type so we take this
    private class Node{ // define linked list class
        K key;//k type key and v type value
        V value;

        public Node(K key, V value){
            this.key=key;
            this.value=value;
        }

    }

    private int n;// total number of nodes
    private int N;//total no.of buckets or array size
   private LinkedList<Node> buckets[];//array  , array name->bucket and its type is LL


   @SuppressWarnings("unchecked") //here we writ this kuch kuch java k versions m warning aati h kyunki LL m complesory hota h LL ka type btana jb unko define krte h to un warnings ko htane k liye ye use krte h
   public HashMap(){ // constructor 
    this.N=4;
    this.buckets=new LinkedList[4];//array initilize
    for(int i=0;i<4;i++){
        this.buckets[i]=new LinkedList<>(); //create empty bucket on each index ,phle starting m hr index pr null store h  no LL so we create empty LL than we can isert data

    }

   }
 // put function is used to add ele in map
   private int hashFunction(K key){ // ye fun bucket index dega and bucket indx should be 0 to N-1
  int bi=key.hashCode();// ye fun key ki value change kr k int value dega koi int value return kr skta h 235476 ,-9878567
  return Math.abs(bi)%N;  //positive value denge to post or neg denge to positive bna dega
   }

   private int searchInLL(K key,int bi){
    LinkedList<Node>ll=buckets[bi];
    //int dataIndx=0;
    for(int i=0;i<ll.size();i++){
        if(ll.get(i).key==key){ //ll.get give node
            return i;//dataindx
        }
    }
    return -1;
   }

   //function of rehashing
   @SuppressWarnings("unchecked")
   private void rehash(){
    LinkedList<Node> oldBucket[]=buckets; //purane data ko oldbucket m store kra diya
   buckets=new LinkedList[N*2];//khali bucket m nyi bucket bna di n*2 size ki

  for(int i=0;i<N*2;i++){//create khali LL ye create isliye kiya h taki hr bar check na krna pde ki LL khali h ya bhri
    buckets[i]=new LinkedList<>();
  }

   for(int i=0;i<oldBucket.length;i++){
    LinkedList<Node> ll=oldBucket[i];
   
    for(int j=0;j<ll.size();j++){
      Node node=ll.get(j);
      put(node.key,node.value);
    }
  } 
  }
   public void put(K key, V value){
     int bi=hashFunction(key);//key ko lega or bucket index dega
     int dataIndx=searchInLL(key,bi);// used to check key it is exist or not in bucket it will give data index, dataIndx LL k ander index btata h konsa state kis index pr h LL m
     //if dataIndx=valid(0+) means it is exist in LL if it give -1 not exist

     if(dataIndx==-1){ // key doesn't exist
     buckets[bi].add(new Node(key,value));//create new node
     n++;
     }
     else{ // key exist
        Node data=buckets[bi].get(dataIndx);//get dataindx index value
             data.value=value;//updata value
     }

     //check lambda value
     double lambda=(double)n/N;
     if(lambda>2.0){
        //rehashing
     rehash();

     }
   }

   public boolean containsKey(K key){
    int bi=hashFunction(key);//key ko lega or bucket index dega
     int dataIndx=searchInLL(key,bi);// used to check key it is exist or not in bucket it will give data index, dataIndx LL k ander index btata h konsa state kis index pr h LL m
     //if dataIndx=valid(0+) means it is exist in LL if it give -1 not exist

     if(dataIndx==-1){ // key doesn't exist
     return false;
     }
     else{ // key exist
         return true;
     }
  
   }

   public V remove(K key){
     int bi=hashFunction(key);//key ko lega or bucket index dega
     int dataIndx=searchInLL(key,bi);// used to check key it is exist or not in bucket it will give data index, dataIndx LL k ander index btata h konsa state kis index pr h LL m
     //if dataIndx=valid(0+) means it is exist in LL if it give -1 not exist

     if(dataIndx==-1){
       // key doesn't exist
       return null;
     }
     else{ // key exist
        Node node=buckets[bi].remove(dataIndx);//get dataindx index value
       n--;
        return node.value;//updata value
     }
    
   }

   public V get(K key){
    int bi=hashFunction(key);//key ko lega or bucket index dega
     int dataIndx=searchInLL(key,bi);// used to check key it is exist or not in bucket it will give data index, dataIndx LL k ander index btata h konsa state kis index pr h LL m
     //if dataIndx=valid(0+) means it is exist in LL if it give -1 not exist

     if(dataIndx==-1){
       // key doesn't exist
       return null;
     }
     else{ // key exist
        Node node=buckets[bi].get(dataIndx);//get dataindx index value
        return node.value;//updata value
     }
    
   }

   public ArrayList<K> keySet(){
    ArrayList<K> keys=new ArrayList<>();
    for(int i=0;i<buckets.length;i++){ //bucket indx
      LinkedList<Node> ll= buckets[i];
      for(int j=0;j<ll.size();j++){ //data indx
        Node node=ll.get(j);
        keys.add(node.key);
      }
    }
    return keys;
   }

   public boolean isEmpty(){
    return n==0;
   }

    }

    public static void main(String[] args) {
      HashMap<String,Integer> map=new HashMap<>();
      map.put("India",200);
      map.put("Tiwala", 300);
      map.put("RJ",700);
     
    ArrayList<String> keys=map.keySet();
    for(int i=0;i<keys.size();i++){
      System.out.println(keys.get(i)+ " " +map.get(keys.get(i)));
    }

    map.remove("India");
    System.out.println(map.get("India"));
    }
}



//IN avg case put() time complexity=O(lambda)
//in worst case->O(n) give if hash function is not good give same output(same bucket index) for many input
//reshashing->O(n)