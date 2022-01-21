package biweekly.biweekly67;

import java.util.*;
import java.io.*;

/**
 * Created on:  Dec 11, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-67/problems/find-subsequence-of-length-k-with-the-largest-sum/
 */

public class FindSubsequenceOfLengthKWithTheLargestSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSubsequence(new int[]{2, 1, 3, 3}, 2)));
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Stack<Integer>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int val = nums[i];
            map.putIfAbsent(val, new Stack<>());
            map.get(val).add(i);
        }
//        Sort the input array and arrange based on index.
        Arrays.sort(nums);
//        Create a k sized array sorted by number.
        int[][] temp = new int[k][2];
        int idx = 0;
        for (int i = len - k; i < len; i++) {
            int val = nums[i];
            temp[idx][0] = val;
            temp[idx][1] = map.get(val).pop();
            idx++;
        }
        return Arrays.stream(temp)
                .sorted((v1, v2) -> Integer.compare(v1[1], v2[1]))
                .mapToInt(arr -> arr[0])
                .toArray();
    }

}
