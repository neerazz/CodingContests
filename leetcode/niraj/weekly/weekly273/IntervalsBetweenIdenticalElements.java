package weekly.weekly273;

import java.util.*;
import java.io.*;

/**
 * Created on:  Dec 25, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-273/problems/intervals-between-identical-elements/
 */

public class IntervalsBetweenIdenticalElements {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(getDistances(new int[]{2, 1, 3, 1, 2, 3, 3})));
        System.out.println(Arrays.toString(getDistances(new int[]{10, 5, 10, 10})));
    }

    public static long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> indices = new HashMap<>();
        Map<Integer, Long> totals = new HashMap<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int num = arr[i];
            List<Integer> preIdxs = indices.getOrDefault(num, new ArrayList<>());
            long preSum = totals.getOrDefault(num, 0L);
            int preIdx = preIdxs.isEmpty() ? 0 : preIdxs.get(preIdxs.size() - 1);
//            long curSum = preSum +
//            totals.put(num, pre + i);
            preIdxs.add(i);
        }
//        Compute Prefix, of the number
//        Compute Suffix, of the number
        long[] result = new long[len];
        for (int i = 0; i < len; i++) {
            int num = arr[i];
//            Integer rep = times.get(num);
//            if (rep > 1) {
//                result[i] = Math.abs((rep * i) - totals.get(num));
//            }
        }
        return result;
    }

}
