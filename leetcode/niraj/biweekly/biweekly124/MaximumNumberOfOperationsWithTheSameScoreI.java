package biweekly.biweekly124;

/**
 * Created on:  February 17, 2024, 9:30 AM
 * Ref: <a href="https://leetcode.com/contest/biweekly-contest-124">MaximumNumberOfOperationsWithTheSameScoreI</a>
 */

public class MaximumNumberOfOperationsWithTheSameScoreI {

    public static void main(String[] args) {

    }

    public int maxOperations(int[] nums) {
        Integer score = null;
        int len = nums.length, count = 0;
        for (int i = 0; i + 1 < len; i += 2) {
            int curScore = nums[i] + nums[i + 1];
            if (score == null || score == curScore) {
                score = curScore;
                count++;
            } else {
                break;
            }
        }
        return count;
    }

}
