package biweekly.biweekly61;

import java.util.Arrays;

/**
 * Created on:  Sep 18, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-61/problems/count-number-of-pairs-with-absolute-difference-k/
 */
public class CountNumberOfPairsWithAbsoluteDifferenceK {
    public static void main(String[] args) {

    }

    public int countKDifference(int[] nums, int k) {
        int pair = 0, len = nums.length;
        Arrays.sort(nums);
//         a-b = k, if( a<b: then find k+a in nums)
        for (int i = 0; i < len; i++) {
            int target = k + nums[i];
            for (int j = i + 1; j < len; j++) {
                if (nums[j] == target) pair++;
                if (nums[j] > target) break;
            }
        }
        return pair;
    }
}
