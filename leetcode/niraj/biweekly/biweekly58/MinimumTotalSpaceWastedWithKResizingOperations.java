package niraj.biweekly.biweekly58;

/**
 * Created on:  Aug 07, 2021
 * Ref : https://leetcode.com/contest/biweekly-contest-58/problems/minimum-total-space-wasted-with-k-resizing-operations/
 */
public class MinimumTotalSpaceWastedWithKResizingOperations {

    public static void main(String[] args) {
        System.out.println(minSpaceWastedKResizing(new int[]{10, 20}, 0) + " = 10");
        System.out.println(minSpaceWastedKResizing(new int[]{10, 20, 30}, 1) + " = 10");
        System.out.println(minSpaceWastedKResizing(new int[]{10, 20, 15, 30, 20}, 2) + " = 15");
        System.out.println(minSpaceWastedKResizing(new int[]{2, 48, 18, 16, 15, 9, 48, 7, 44, 48}, 1) + " = 179");
    }

    public static int minSpaceWastedKResizing(int[] nums, int k) {
        int len = nums.length;
        Integer[][] dp = new Integer[len][len];
        return dp(nums, 0, len, dp, k);
    }

    private static int dp(int[] nums, int idx, int len, Integer[][] dp, int k) {
        if (idx == len) return 0;
        if (k < 0) return Integer.MAX_VALUE/10;
        if (dp[idx][k] != null) return dp[idx][k];
        int cur = Integer.MAX_VALUE/10, maxNum = 0, sum = 0;
//        At each recursion find out a window with size 1 till end.
        for (int i = idx; i < len; i++) {
//          Fix the max number in the window
            maxNum = Math.max(maxNum, nums[i]);
//          Calculate the wastage for that window, but multiplying the max value with window size and the window sum.
            sum += nums[i];
            int wasted = maxNum * (i - idx + 1) - sum;
            int next = dp(nums, i + 1, len, dp, k - 1);
            cur = Math.min(cur, next + wasted);
        }
        return dp[idx][k] = cur;
    }
}
