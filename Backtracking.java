public class Backtracking {
    public static void printPerm(String str,String perm,int indx){
       if(str.length()==0){
        System.out.println(perm);
        return;
       }
        for(int i=0;i<str.length();i++){
            char currchar=str.charAt(i);
            String newStr = str.substring(0,i) + str.substring(i+1);
            printPerm(newStr,perm+currchar,indx+1);
        }
    }
    public static void main(String[] args) {
        String str = "ABC";
        printPerm(str,"",0);
    }
    
}
