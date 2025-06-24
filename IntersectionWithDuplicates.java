
    
import java.util.*;

public class IntersectionWithDuplicates {

    // ✅ Method to find intersection with duplicates
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Step 1: Store frequency of elements in nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Check each element in nums2
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num); // add to result list
                map.put(num, map.get(num) - 1); // reduce count
            }
        }

        // Step 3: Convert List to Array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    // ✅ Main function to test
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};

        int[] result = intersect(nums1, nums2);

        System.out.print("Intersection with duplicates: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}


/*🧠 Dry Run (nums1 = [4,9,5], nums2 = [9,4,9,8,4]):
Map after nums1: {4=1, 9=1, 5=1}

Scan nums2:

9 → yes → add 9 → update map: 9=0

4 → yes → add 4 → update map: 4=0

9 again → skip (already used)

8 → skip

4 again → skip

✅ Output → [9, 4] or [4, 9] (order doesn't matter)

✅ Time & Space Complexity:
Part	Complexity
Time	O(n + m)
Space (Map/List)	O(n)

*/