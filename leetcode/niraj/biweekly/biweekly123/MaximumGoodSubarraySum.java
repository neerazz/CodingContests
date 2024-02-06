package biweekly.biweekly123;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  February 3, 2024, 9:33 AM
 * Ref: <a href="https://leetcode.com/contest/biweekly-contest-123">MaximumGoodSubarraySum</a>
 */

public class MaximumGoodSubarraySum {

    public static void main(String[] args) {
        System.out.println(maximumSubarraySum(new int[]{1, 2, 3, 4, 5, 6}, 1) + " = 11");
        System.out.println(maximumSubarraySum(new int[]{-1, 3, 2, 4, 5}, 3) + " = 11");
        System.out.println(maximumSubarraySum(new int[]{-1, -2, -3, -4}, 2) + " = -6");
        System.out.println(maximumSubarraySum(new int[]{1, 3, 8, 9, 5}, 4) + " = 26");
        System.out.println(maximumSubarraySum(
                new int[]{-636, -784, -356, -832, -797, -978, -651, -667, -907, -900, -168, -697, -879, -998, -126, -900, -542, -553, -268, -374, -710, -768, -727, -975, -106, -756, -462, -815, -276, -163, -301, -822, -367, -685, -581, -488, -763, -612, -847, -730, -479, -874, -221, -912, -229, -543, -876, -845, -424, -215, -819, -164, -840, -525, -987, -291, -658, -168, -382, -781, -951, -396, -228, -394, -445, -863, -290, -675, -289, -950, -885, -228, -624, -236, -437, -246, -302, -741, -243, -419, -851, -980, -667, -661, -140, -893, -328, -354, -359, -845, -396, -309, -450, -941, -310, -119, -614, -854, -599, -605},
                8) + " = -1088");
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Long> sums = new HashMap<>();
        long sum = 0, max = Long.MIN_VALUE;

        for (int num : nums) {
            int diff1 = num - k, diff2 = num + k;
            if (sums.containsKey(diff2)) {
                long minValue = sums.get(diff2);
                max = Math.max(max, sum + num - minValue);
            }
            if (sums.containsKey(diff1)) {
                long minValue = sums.get(diff1);
                max = Math.max(max, sum + num - minValue);
            }
//             As per Khadens algorithm, Find the current Best possible number that will result in a better result.
//            In this case, logic for calculating the maximum sum of a good subarray relies on accurately knowing
//               the minimum starting sum for potential good subarrays.
            long curMinSum = Math.min(sums.getOrDefault(num, Long.MAX_VALUE), sum);
            sums.put(num, curMinSum);
            sum += num;
        }
        return max == Long.MIN_VALUE ? 0 : max;
    }

    public static long maximumSubarraySum_naive(int[] nums, int k) {
        int len = nums.length;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            long sum = nums[i];
            for (int j = i + 1; j < len; j++) {
                sum += nums[j];
                if (Math.abs(nums[i] - nums[j]) == k) {
                    max = Math.max(max, sum);
                }
            }
        }
        return max == Long.MIN_VALUE ? 0 : max;
    }

}
