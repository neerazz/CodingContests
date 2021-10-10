package weekly.weekly262;

import java.util.*;

/**
 * Created on:  Oct 03, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-261/problems/find-missing-observations/
 */

public class MinimumOperationsToMakeAUniValueGrid {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[][]{{931, 128}, {639, 712}}, 73));
    }

    public static int minOperations_center(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int[] row : grid) {
            for (int num : row) {
                list.add(num);
            }
        }
        Collections.sort(list);
        int center = list.get(list.size() / 2);
        for (int val : list) {
            int diff = Math.abs(val - center);
            if (diff % x != 0) return -1;
            count += diff / x;
        }
        return count;
    }

    public static int minOperations(int[][] grid, int x) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        int[] rem = new int[x];
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        for (int[] row : grid) {
            for (int val : row) {
                map.put(val, map.getOrDefault(val, 0) + 1);
                rem[val % x]++;
                min = Math.min(min, val);
                max = Math.max(max, val);
            }
        }
        Set<Integer> rems = new HashSet<>();
        if (canform(rem, rems)) {
            int curRem = rems.iterator().next();
            int start = min / x, end = max / x;
            int result = Integer.MAX_VALUE;
            for (int i = start; i <= end; i++) {
                int steps = getSteps(map, x * i + curRem, x);
                result = Math.min(result, steps);
            }
            return result == Integer.MAX_VALUE ? -1 : result;
        }
        return -1;
    }

    static int getSteps(Map<Integer, Integer> map, int tar, int x) {
        int count = 0;
        for (int val : map.keySet()) {
            int times = Math.abs(val - tar) / x;
            count += map.get(val) * times;
        }
//        System.out.println("Changing all values to :" + tar + " in " + count + " steps.");
        return count;
    }

    static boolean canform(int[] rem, Set<Integer> rems) {
        for (int i = 0; i < rem.length; i++) {
            if (rem[i] == 0) continue;
            rems.add(i);
        }
        // System.out.println("Rem = " + Arrays.toString(rem) + " Set = " + counts);
        return rems.size() == 1;
    }
}
