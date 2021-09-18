package biweekly.biweekly61;

import java.util.*;

/**
 * Created on:  Sep 18, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-61/problems/find-original-array-from-doubled-array/
 */
public class FindOriginalArrayFromDoubledArray {
    public static void main(String[] args) {

    }

    public int[] findOriginalArray(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if(len %2 != 0) return new int[0];
        int[] result = new int[len / 2];
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int half = num / 2;
            if (num % 2 == 0 && map.containsKey(half)) {
                result[i++] = half;
                int occ = map.remove(half);
                if (occ > 1) map.put(half, occ - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        return i == result.length ? result : new int[0];
    }
}
