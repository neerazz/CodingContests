package weekly.weekly256;

import java.util.*;

/**
 * Created on:  Aug 28, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-256/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 */
public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public static void main(String[] args) {

    }

    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<len && i+k <= len; i++){
            int start = nums[i], end = nums[i+k-1];
            min = Math.min(min, end-start);
        }
        return min;
    }
}
