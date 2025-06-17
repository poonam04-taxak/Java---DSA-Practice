import java.util.List;
import java.util.ArrayList;
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findComb(arr, target, new ArrayList<>(), result, 0);
        return result;
    }

    public void findComb(int[] arr, int target, List<Integer> current, List<List<Integer>> result, int indx) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || indx == arr.length) return;

        // include current element
        current.add(arr[indx]);
        findComb(arr, target - arr[indx], current, result, indx); // reuse same element
        current.remove(current.size() - 1); // backtrack

        // exclude current element
        findComb(arr, target, current, result, indx + 1);
    }

    public static void main(String[] args) {
        CombinationSum s = new CombinationSum(); // create object
        int[] arr = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = s.combinationSum(arr, target); // call combinationSum

        System.out.println("Target: " + target);
        for (List<Integer> comb : result) {
            System.out.println(comb);
        }
    }
}

