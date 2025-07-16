public class AccessModifier {
 static  class Student{
     private   String name;
       private int age;
       private int marks;
    
    public void set(String name,int age,int marks){
        this.name=name;
        this.age=age;
        if(marks<0){
            this.marks=0;

        }
        else if(marks>100){
            this.marks=100;
        }
        else{
         this.marks=marks;
        }
    }
    public void get(){
       
         System.out.println("name of student is:" +name);
          System.out.println("age of student is:" +age);
           System.out.println("marks of student is:" +marks);
    
    
        }
        }
    public static void main(String[] args) {
        Student s=new Student();
        s.set("poonam",22,105);
        s.get();
    }
}
