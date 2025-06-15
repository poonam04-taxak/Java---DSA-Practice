public class Subsequence {
    public static void printSub(String str, int index, String curr) {
        if (index == str.length()) {
            System.out.println(curr);
            return;
        }

        // include the current character
        printSub(str, index + 1, curr + str.charAt(index));

        // exclude the current character
        printSub(str, index + 1, curr);
    }

    public static void main(String[] args) {
        String str = "abc";
        printSub(str, 0, "");
    }
}
 