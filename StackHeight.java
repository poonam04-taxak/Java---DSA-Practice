public class StackHeight {
    public static int calcPow(int x,int n){    //calcPow(2, 5)
                                                // → calcPow(2, 4)
                                                   // → calcPow(2, 3)
                                                   //    → calcPow(2, 2)
                                                            //      → calcPow(2, 1)
                                                       //→ calcPow(2, 0) → returns 1
     if(n==0){
            return 1;
        }
        if(x==0){
            return 0;
        }
   
        int pownumb = calcPow(x,n-1);
        int num=x*pownumb;
        return num;
    }
    public static void main(String[] args) {
        int x=2, n=5;
        int ans=calcPow(x,n);
        System.out.println(ans);
    }
    
}


/* optimized power calculation method using Divide and Conquer.
This reduces time complexity from O(n) to O(log n) and also reduces the stack height in recursion. ✅
public class OptimizedPower {
    public static int calcPower(int x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;

        System.out.println("Calling for n = " + n);

        int halfPower = calcPower(x, n / 2);

        if (n % 2 == 0) {
            return halfPower * halfPower;
        } else {
            return x * halfPower * halfPower;
        }
    }

    public static void main(String[] args) {
        int x = 2, n = 5;
        int ans = calcPower(x, n);
        System.out.println("Final answer: " + ans);
    }
}
 */