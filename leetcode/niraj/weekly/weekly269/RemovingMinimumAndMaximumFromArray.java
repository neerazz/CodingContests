package weekly.weekly269;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  Nov 27, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-269/problems/removing-minimum-and-maximum-from-array/
 */

public class RemovingMinimumAndMaximumFromArray {

    public static void main(String[] args) {

    }

    public static int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int minIdx = 0, maxIdx = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        int onLeft = Math.max(minIdx, maxIdx) + 1;
        int onRight = len - Math.min(minIdx, maxIdx);
        int both = (Math.min(minIdx, maxIdx) + 1) + (len - Math.max(minIdx, maxIdx));
        return Math.min(both, Math.min(onLeft, onRight));
    }

    public static int minimumDeletions_dp(int[] nums) {
        int len = nums.length;
        if (len <= 2) return len;
        Integer[][] dp = new Integer[len][len];
        Set<Integer> removed = new HashSet<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return helper(nums, 0, len - 1, dp, removed, min, max);
    }

    static int helper(int[] nums, int start, int end, Integer[][] dp, Set<Integer> removed, int min, int max) {
        if (start > end) return 0;
        if (removed.contains(min) && removed.contains(max)) return 0;
        if (dp[start][end] != null) return dp[start][end];
        // There are two options
        removed.add(nums[start]);
        int left = helper(nums, start + 1, end, dp, removed, min, max);
        removed.remove(nums[start]);
        removed.add(nums[end]);
        int right = helper(nums, start, end - 1, dp, removed, min, max);
        removed.remove(nums[end]);
        int next = Math.min(left, right);
        return dp[start][end] = next == Integer.MAX_VALUE ? Integer.MAX_VALUE : next + 1;
    }

}
