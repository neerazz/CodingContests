package weekly.weekly257;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Sep 12, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-257/problems/first-day-where-you-have-been-in-all-the-rooms/
 */
public class FirstDayWhereYouHaveBeenInAllTheRooms {
    public static void main(String[] args) {

    }

    public int firstDayBeenInAllRooms_naive(int[] nextVisit) {
        int len = nextVisit.length;
        long count = 0, mod = 1_000_000_007;
        Set<Integer> visited = new HashSet<>();
        int[] counts = new int[len];
        int room = 0;
        while (visited.size() < len) {
            counts[room]++;
            int next = nextVisit[room];
            if (counts[room] % 2 == 0) {
                next = (room + 1) % len;
            }
            visited.add(room);
            if (visited.size() == len) break;
            room = next;
            count++;
            count %= mod;
        }
        return (int) (count % mod);
    }
}
