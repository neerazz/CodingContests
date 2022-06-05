package weekly.weekly286;

import java.util.*;
import java.io.*;

/**
 * Created on:  April 2, 2022, 12:53 PM
 * Ref: https://leetcode.com/contest/weekly-contest-286
 */

public class FindTheDifferenceOfTwoArrays {

    public static void main(String[] args) {

    }

    public static int minDeletion(int[] nums) {
        int len = nums.length;
        Integer[] dp = new Integer[len];
        return helper(nums, 0,  len, dp);
    }

    private static int helper(int[] nums, int start, int len, Integer[] dp){
        if(start == len) return 0;
        if(start == len -1) return 1;
        if(dp[start] != null) return dp[start];
        int left = nums[start], right = nums[start+1];
        int noDeleteCount = helper(nums, start+2, len, dp);
        int leftDeleteCount = 1 + helper(nums, start+1, len, dp);
//        Check till what point can the right delete be done.
        int rightDeleteCount = Integer.MAX_VALUE;
        for(int i = start+1; i<len; i++){
            if(left != nums[i]){
                int next = helper(nums, i+1, len, dp);
                int deleted = i - start - 1;
                rightDeleteCount = Math.min(rightDeleteCount, deleted + next);
            }
        }
        int best = Math.min(leftDeleteCount, rightDeleteCount);
        if(left != right){
            best = Math.min(best, noDeleteCount);
        }
        return dp[start] = best;
    }

}
