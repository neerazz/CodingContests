package weekly.weekly381;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created on:  January 20, 2024, 11:27 PM
 * Ref: <a href="https://leetcode.com/contest/weekly-contest-381">MinimumNumberOfPushesToTypeWordI</a>
 */

public class MinimumNumberOfPushesToTypeWordI {

    public static void main(String[] args) {

    }

    public static int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<NChar> queue = new PriorityQueue<>((a, b) -> b.count - a.count);
        for (var entry : map.entrySet()) {
            queue.add(new NChar(entry.getValue(), entry.getKey()));
        }
        int sum = 0;
        int keysTaken = 0;
        while (!queue.isEmpty()) {
            var pop = queue.poll();
            sum += pop.count * ((keysTaken / 8) + 1);
            // System.out.println("Char : " + pop.c + " Count : " + pop.count + " Sum =" + sum);
            keysTaken++;
        }
        return sum;
    }

    static class NChar {
        int count;
        char c;

        NChar(int count, char c) {
            this.count = count;
            this.c = c;
        }
    }

}
