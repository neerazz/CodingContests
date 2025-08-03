package biweekly.biweekly124;

/**
 * Created on:  February 17, 2024, 9:30 AM
 * Ref: <a href="https://leetcode.com/contest/biweekly-contest-124">MaximumNumberOfOperationsWithTheSameScoreII</a>
 */

public class MaximumNumberOfOperationsWithTheSameScoreII {

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{3, 2, 1, 2, 3, 4}) + " = 3");
        System.out.println(maxOperations(new int[]{3, 2, 6, 1, 4}) + " = 2");
        System.out.println(maxOperations(new int[]{3, 2, 1, 4, 1}) + " = 2");
        System.out.println(maxOperations(new int[]{1, 9, 7, 3, 2, 7, 4, 12, 2, 6}) + " = 2");
    }

    public static int maxOperations(int[] nums) {
        int len = nums.length;
        Integer[][] dp = new Integer[len][len];
        return helper(nums, 0, len - 1, null, dp);
    }

    private static int helper(int[] nums, int start, int end, Integer sum, Integer[][] dp) {
        if (dp[start][end] != null) return dp[start][end];
        int diff = end - start + 1;
        if (diff < 2) {
            return 0;
        }
        int result = 0;
        int s1 = nums[start] + nums[start + 1];
        int s2 = nums[start] + nums[end];
        int s3 = nums[end - 1] + nums[end];
        int op1;
        int op2;
        int op3;
        if (sum == null) {
            op1 = 1 + helper(nums, start + 2, end, s1, dp);
            op2 = 1 + helper(nums, start + 1, end - 1, s2, dp);
            op3 = 1 + helper(nums, start, end - 2, s3, dp);
        } else {
            op1 = s1 == sum ? 1 + helper(nums, start + 2, end, s1, dp) : 0;
            op2 = s2 == sum ? 1 + helper(nums, start + 1, end - 1, s2, dp) : 0;
            op3 = s3 == sum ? 1 + helper(nums, start, end - 2, s3, dp) : 0;
        }
        result = Math.max(op1, Math.max(op2, op3));
        return dp[start][end] = result;
    }

}
