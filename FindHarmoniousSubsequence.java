
import java.util.*;

public class FindHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        // Count frequency of each element
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxLen = 0;

        // Check for harmonious subsequences
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int length = map.get(key) + map.get(key + 1);
                maxLen = Math.max(maxLen, length);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        FindHarmoniousSubsequence sol = new FindHarmoniousSubsequence();

        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.println(sol.findLHS(nums));  // Output: 5

        int[] nums2 = {1,2,3,4};
        System.out.println(sol.findLHS(nums2)); // Output: 2

        int[] nums3 = {1,1,1,1};
        System.out.println(sol.findLHS(nums3)); // Output: 0
    }
}

