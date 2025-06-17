
    public class QuickSort {

    // QuickSort function
    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pi = partition(arr, start, end);

            // Recursively sort left and right subarrays
            quickSort(arr, start, pi - 1);
            quickSort(arr, pi + 1, end);
        }
    }

    // Partition function
    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];  // last element is pivot
        int i = start - 1;     // pointer for smaller element

        for (int j = start; j < end; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot at correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}


