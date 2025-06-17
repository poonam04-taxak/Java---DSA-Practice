import java.util.*;
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr); // step 1: sort to handle duplicates
        backtrack(arr, target, 0, new ArrayList<>(), result);
        return result;
    }

    // Recursive function
    private void backtrack(int[] arr, int target, int index, List<Integer> current, List<List<Integer>> result) {
        // base case: target matched
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // loop from current index to end
        for (int i = index; i < arr.length; i++) {
            // Step 2: skip duplicates
            if (i > index && arr[i] == arr[i - 1]) continue;

            // Step 3: if current element is greater than target, break (no use going ahead)
            if (arr[i] > target) break;

            // Step 4: pick current element
            current.add(arr[i]);

            // Step 5: call recursion for next index
            backtrack(arr, target - arr[i], i + 1, current, result); // i+1 because we can't reuse same element

            // Step 6: backtrack (remove last added element)
            current.remove(current.size() - 1);
        }
    }

    // For testing
    public static void main(String[] args) {
        CombinationSum2 sol = new CombinationSum2();
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> output = sol.combinationSum2(arr, target);
        for (List<Integer> comb : output) {
            System.out.println(comb);
        }
    }
}


