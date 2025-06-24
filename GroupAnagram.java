 import java.util.*;

public class GroupAnagram{

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Step 1: Sort the string → this will be our key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars); // e.g., "eat" -> "aet"

            // Step 2: Add the string to map under the sorted key
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        // Step 3: Return all groups of anagrams
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = groupAnagrams(words);

        // Print result
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
 
/*✅ Time & Space Complexity:
Metric	Value
Time	O(n * k log k)
Space	O(n * k)
n = # of strings, k = avg length 

🔹 Iteration:
"eat" → sort → "aet" → map: "aet" → ["eat"]

"tea" → sort → "aet" → map: "aet" → ["eat", "tea"]

"tan" → sort → "ant" → map: "ant" → ["tan"]

"ate" → sort → "aet" → map: "aet" → ["eat", "tea", "ate"]

"nat" → sort → "ant" → map: "ant" → ["tan", "nat"]

"bat" → sort → "abt" → map: "abt" → ["bat"]

*/