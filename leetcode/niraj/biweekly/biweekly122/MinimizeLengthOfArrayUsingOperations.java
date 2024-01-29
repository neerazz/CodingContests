package biweekly.biweekly122;

/**
 * Created on:  January 20, 2024, 9:30 AM
 * Ref: <a href="https://leetcode.com/contest/biweekly-contest-122">MinimizeLengthOfArrayUsingOperations</a>
 */

public class MinimizeLengthOfArrayUsingOperations {

    public static void main(String[] args) {

    }

    public static int minimumArrayLength(int[] nums) {
        // Find the minimum element and count its occurrences
        int minElement = Integer.MAX_VALUE;
        int minCount = 0;
        for (int num : nums) {
            minElement = Math.min(minElement, num);
        }
        for (int num : nums) {
            if (num % minElement > 0) {
                return 1;
            }
        }
        for (int num : nums) {
            if (num == minElement) {
                minCount++;
            }
        }

        // The minimum length depends on the count of the smallest element
        return (int) ((minCount + 1) / 2.0);
    }

}
