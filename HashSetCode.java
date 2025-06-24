//import java.util.Iterator;
import java.util.*;
public class HashSetCode{
    public static void main(String args[]){
        HashSet<Integer> set=new HashSet<>();
        //for adding ele use .add function
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);

        //for searching use contains function
        if(set.contains(1)){
            System.out.println("our set contains 1");
        }
        if(!set.contains(8)){
            System.out.println("does not contain this value");
        }

        //for finding size of set
        System.out.println(set.size());

        //for printing all elements of set
        System.out.println(set);

        //for delete use .remove()
        set.remove(1);
        if(!set.contains(1)){
        System.out.println("you delete 1"); 
        }
     
        //for iteration use iterator    not use for loop
        Iterator<Integer> it = set.iterator();

        //iterator has mainly two functions for traversal->next() and hasnext()
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }

}