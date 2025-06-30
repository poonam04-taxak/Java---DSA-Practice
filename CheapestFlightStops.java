/*🔸 Problem kya keh raha hai?
Flights diye hain (from, to, price).

src se dst tak jaana hai at most k stops me (matlab max k+1 flights).

Sabse kam paisa lagne wala rasta batao.

Agar nahi jaa sakte to -1 return karo.

🔸 Bellman-Ford ko isme kyu use karte hain?
Bellman-Ford me hum V-1 baar relax karte hain.

Yahan max k+1 flights allowed hain, to hum k+1 baar relax karenge.

Relax ka matlab:

Har baar sare edges dekhkar ye check karna ki src se kisi node tak kam cost me ja sakte hain kya.

🔸 Approach simple shabdon me:
✅ dist[] array lo, sabko infinity se fill karo, src ko 0 rakho.

✅ k+1 baar loop chalana hai (kyunki max k stops hain).

✅ Har iteration me:

ek temp[] lo dist[] ka copy bana kar,

sari flights check karo:

agar u tak pahuch sakte ho (dist[u] != inf),

aur u se v tak jane me kam cost lag rahi hai (dist[u] + wt < temp[v]),

to temp[v] ko update karo.

✅ dist = temp kar do har iteration ke baad.

✅ Last me dist[dst] check karo:

agar inf hai to -1 return karo,

warna dist[dst] return karo.

 */
import java.util.*;

public class CheapestFlightStops {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n]; // distance array
        Arrays.fill(dist, Integer.MAX_VALUE); // sabko infinity se fill karo
        dist[src] = 0; // src tak cost 0 hogi

        for (int i = 0; i <= k; i++) { // max k+1 flights allowed
            int[] temp = dist.clone(); // har iteration me copy banao

            for (int[] flight : flights) { // sari flights dekh lo
                int u = flight[0]; // from
                int v = flight[1]; // to
                int wt = flight[2]; // price

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < temp[v]) {
                    temp[v] = dist[u] + wt; // kam cost wali path mil gayi
                }
            }

            dist = temp; // update for next iteration
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst]; // agar inf hai to -1 warna cost
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 0, 100},
            {1, 3, 600},
            {2, 3, 200}
        };
        int src = 0, dst = 3, k = 1;

        System.out.println(findCheapestPrice(n, flights, src, dst, k)); 
        // Output: 700
    }
}
