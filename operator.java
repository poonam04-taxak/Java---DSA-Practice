public class operator {
    public static void main(String[] args) {
        System.out.println('a' + 'b');//if we use - it will give an error and + is only used for primitive data type
        System.out.println("a" + "b");
        System.out.println((char)('a' + 3));

        System.out.println("a" + 1);
        // this is same as after a few steps:"a" + "1"
        //integer will be converted to Integer that will call toString()

       // System.out.println("poonam" + new ArrayList<>()); // when we creat any obj it automatically call toString method
        System.out.println("poonam" + new Integer(34)); //here Integer ia s object and it will call toString() method    
    // System.out.println(new Integer(3) + new ArrayList<>());// show an error bcoz + can't be used for int and arraylist
    //i java + is only used for primitive data and strings
//String ans =(new Integer(6) + " " + new ArrayList<>()); //this will work in java at list one have of object string so we add " "   
//System.out.println(ans);
}
    
}
