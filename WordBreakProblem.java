
public class WordBreakProblem {

    static class Node{
        Node[] children;//represent each node of trie A-Z->26 size
        boolean EndOfWord;

        //constructor
        public Node(){
            children=new Node[26];//a to z
            for(int i=0;i<26;i++){ // initilization of children
                children[i]=null;//in starting the root does not have info about its child and if we not write this we can get a error.here now memory is not allocated so we use null
            }
            EndOfWord=false;
        }
    }

    //create root node
    static Node root=new Node(); //hmesa empty rhti h only store info of it's child 
       //root static h or insert m or search m hmne hr bar root ko update kiya h or ak bar kisi fun n root ki value change kr di to vo hmesa k liye change ho jayegi pr root ki value fix honi chahiye to hmne curr le liya
//ye ak bar change ho gya to change hi rhega
    public static void insert(String word){
        Node currRoot=root;
        for(int i=0;i<word.length();i++){// T.C->O(L) here L is Length of word
            //now find index 
            //'a'-'a'=0  'b'-'a'=2  'c'-'a'=3
            int indx=word.charAt(i)-'a'; // charAt give char of ith index

            //check root k child m node exit h ya nhi nhi h to create new node h to nothing move to next word
            if(currRoot.children[indx]==null){
                //add new node
                currRoot.children[indx]=new Node();
            }
            //End of word condition
            if(i==word.length()-1){
               currRoot.children[indx].EndOfWord=true; 
            }
            currRoot=currRoot.children[indx];//update root
     
        }

    }

    //search in trie T.C=O(L)
    public static boolean search(String key){
        Node currRoot=root;
        for(int i=0;i<key.length();i++){
           int indx=key.charAt(i)-'a';
           
           if(currRoot.children[indx]==null){
            return false;
           }
           if(i==key.length()-1 && currRoot.children[indx].EndOfWord==false){
            //iska mtlb hme key to mil gyi pr end of word nhi mila to  ans false hoga ex=an ko dekh to an tree m to h pr n end of word nhi h
            return false;
           }
           //update root
           currRoot=currRoot.children[indx];
        }
        return true;
    }
    //problem code
    public static boolean wordBreak(String key){
        if(key.length()==0){
            //empty string
            return true;
        }

        //make small parts of large string
        for(int i=1;i<=key.length();i++){
            String firstPart=key.substring(0, i);//i will not include 0,1 to 1 include nhi hoga
            String secPart=key.substring(i);//start with i
    
        if(search(firstPart)&& wordBreak(secPart)){
            return true;//first and sec part both true

        }
        }
        return false;//not possible to break string in parts
    }
    public static void main(String[] args) {
        String words[]={"i","like","sam","samsung","mobile"};
        String key="ilikesamsung";
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        System.out.println(wordBreak(key));
    }
}
