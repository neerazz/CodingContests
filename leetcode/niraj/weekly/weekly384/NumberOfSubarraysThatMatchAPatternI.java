package weekly.weekly384;

/**
 * Created on:  February 11, 2024, 11:44 AM
 * Ref: <a href="https://leetcode.com/contest/weekly-contest-384">NumberOfSubarraysThatMatchAPatternI</a>
 */

public class NumberOfSubarraysThatMatchAPatternI {

    public static void main(String[] args) {

    }

    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int l = nums.length, p = pattern.length;
        int count = 0;
        for (int i = 0; i < l; i++) {
            if (i + p >= l) continue;
            boolean isValid = true;
            for (int j = 0; j < p; j++) {
                int pVal = pattern[j];
                if (pVal > 0) {
                    isValid = nums[i + j] < nums[i + j + 1];
                } else if (pVal == 0) {
                    isValid = nums[i + j] == nums[i + j + 1];
                } else {
                    isValid = nums[i + j] > nums[i + j + 1];
                }
                if (!isValid) break;
            }
            count += isValid ? 1 : 0;
        }
        return count;
    }

}
