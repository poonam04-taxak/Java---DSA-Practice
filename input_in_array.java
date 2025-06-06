/*import java.util.Scanner;
public class input_in_array {
    public static void main(String[] args) {
        Scanner arr = new Scanner(System.in);
        int [] s = new int[2]; // array of size 2
        System.out.println("enter your elements");
        for(int i=0;i<s.length;i++){
            s[i]= arr.nextInt();
        }
        System.out.println("elements are:");
        for(int i=0;i<s.length;i++){
            System.out.print(s[i] + " ");
        }
        arr.close();

    }
}
 */



// question

/*import java.util.Scanner;
public class input_in_array{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        System.out.println("enter your elements:");
        for(int i=0;i<arr.length;i++){
            arr[i]= sc.nextInt();
        }
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>50)
            {
                count++;
            }
        }
        System.out.println("count" + count);
        }
    } */



    //new question

    import java.util.Scanner;
    class input_in_array{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int[] arr = new int[5];
            System.out.println("enter your elements:");
            for(int i= 0;i<arr.length;i++){
                arr[i]=sc.nextInt();
            }
        /*     int max=arr[0];
            for(int i=0;i<arr.length;i++){
                if(arr[i]>max){
                    max=arr[i];
                    
                }
            }
            System.out.println("maximum number is:" +max);
            sc.close();

        }
    }*/
    int even=0;
    int odd=0;
    for(int i=0;i<arr.length;i++){
    if(arr[i] % 2 ==0){
    
        even++;

    }
    else{
        odd++;
    }
    }
    System.out.println("even count" + even);
    System.out.println("odd count" + odd);

sc.close();
    }
    }

    
    