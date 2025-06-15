public class CalcFactorial {
    public static int calcFactorial(int n){
        if(n==1 || n==0){
            return 1;
        }
       int fact_no= calcFactorial(n-1);
       int fact_total = n*fact_no;
       return fact_total;
    }
    public static void main(String args[]){
        int n=5;
        int result=calcFactorial(n);
        System.out.println(result);
    }
    
}
