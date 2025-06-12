public class FindMinInRotatedArray {
    public static int findMin(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // 🔸 If mid element is greater than end,
            // it means minimum is in right half
            if (arr[mid] > arr[end]) {
                start = mid + 1;
            }
            // 🔸 Else, minimum is in left half including mid
            else {
                end = mid;
            }
        }

        // 🔹 Loop ends when start == end ➝ minimum element
        return arr[start];
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int min = findMin(arr);
        System.out.println("Minimum element is: " + min);  // Output: 0
    }
}
