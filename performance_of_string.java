public class performance_of_string {
    public static void main(String[] args) {
        String ab = " ";
        for(int i=0;i<26;i++){
            char ch = (char)('a'+ i);
            ab = ab +ch;//we can add add them ab +=ch
        }
            System.out.println(ab);
        
    }
}
