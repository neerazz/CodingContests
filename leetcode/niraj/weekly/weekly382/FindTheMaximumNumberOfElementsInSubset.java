package weekly.weekly382;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  January 27, 2024, 9:30 PM
 * Ref: <a href="https://leetcode.com/contest/weekly-contest-382">FindTheMaximumNumberOfElementsInSubset</a>
 */

public class FindTheMaximumNumberOfElementsInSubset {

    public static void main(String[] args) {
        System.out.println(maximumLength(new int[]{5, 4, 1, 2, 2}) + " = 3");
        System.out.println(maximumLength(new int[]{1, 3, 2, 4}) + " = 1");
        System.out.println(maximumLength(new int[]{1, 2, 3}) + " = 1");
        System.out.println(maximumLength(new int[]{14, 14, 196, 196, 38416, 38416}) + " = 5");
        System.out.println(maximumLength(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024}) + " = 9");
    }

    private static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    private static int helper(int current, Map<Integer, Integer> map) {
        int occ = map.getOrDefault(current, 0);
        if (occ <= 1) {
            return 0;
        }
        if (isPerfectSquare(current)) {
            int pos = helper((int) Math.sqrt(current), map);
            return pos + 2;
        } else {
            return 2;
        }
    }

    public static int maximumLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int onesCount = map.containsKey(1) ? map.remove(1) : 0;
        int count = 0;
        for (var entry : map.entrySet()) {
            int number = entry.getKey();
            if (isPerfectSquare(number)) {
                int pos = helper((int) Math.sqrt(number), map);
                count = Math.max(count, pos + 1);
            }
        }
        count = Math.max(count, onesCount % 2 == 0 ? onesCount - 1 : onesCount);
        return count;
    }

}
