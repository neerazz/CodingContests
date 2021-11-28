package weekly.weekly269;

import java.util.Arrays;

/**
 * Created on:  Nov 27, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-269/problems/k-radius-subarray-averages/
 */

public class KRadiusSubarrayAverages {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3)));
    }

    public static int[] getAverages(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        long sum = 0, total = 2L * k + 1;
        int k1 = k, p1 = 0, p2 = 0;
        while (p2 < len && p2 < total-1) {
            sum += nums[p2++];
        }
        while (p2 < len) {
            sum += nums[p2++];
            int cur = (int) (sum / total);
            result[k1++] = cur;
            sum -= nums[p1++];
        }
        return result;
    }

}
