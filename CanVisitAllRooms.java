/*🪐 Problem: Keys and Rooms
Tumhare paas n rooms hain (0 se n-1 tak numbered). Tum room 0 se start karti ho, aur har room me kuch keys mil sakti hain jo tumhe doosre rooms kholne me madad karegi.

Tumhe check karna hai:

Kya tum sabhi rooms ko visit kar sakti ho ya nahi?

✅ Input:
List<List<Integer>> rooms:

rooms.get(i) = List of keys available in room i.

✅ Output:
true → agar tum sabhi rooms visit kar sakti ho.

false → agar koi room visit nahi ho sakta.

✅ Example:
Input:

lua
Copy code
rooms = [[1], [2], [3], []]
Room 0: key to 1

Room 1: key to 2

Room 2: key to 3

Room 3: no keys

Output:

arduino
Copy code
true
✅ Tum room 0 se room 1 → room 2 → room 3 tak sequentially sabhi rooms visit kar sakti ho.

 */
import java.util.*;

public class CanVisitAllRooms {
    public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));       // Room 0 has key to 1
        rooms.add(Arrays.asList(2));       // Room 1 has key to 2
        rooms.add(Arrays.asList(3));       // Room 2 has key to 3
        rooms.add(new ArrayList<>());      // Room 3 has no keys

        boolean canVisit = sol.canVisitAllRooms(rooms);
        System.out.println("Can visit all rooms? " + canVisit);
    }
}

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visit = new boolean[n];

        dfs(0, rooms, visit);

        for (boolean v : visit) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visit) {
        visit[room] = true;

        for (int key : rooms.get(room)) {
            if (!visit[key]) {
                dfs(key, rooms, visit);
            }
        }
    }
}
