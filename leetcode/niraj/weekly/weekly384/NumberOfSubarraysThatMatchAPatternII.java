package weekly.weekly384;

/**
 * Created on:  February 11, 2024, 11:44 AM
 * Ref: <a href="https://leetcode.com/contest/weekly-contest-384">NumberOfSubarraysThatMatchAPatternII</a>
 */

public class NumberOfSubarraysThatMatchAPatternII {

    public static void main(String[] args) {
//        System.out.println(countMatchingSubarrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 1}) + " = 4");
        System.out.println(countMatchingSubarrays(new int[]{73313829, 62128998, 73313829}, new int[]{1}) + " = 1");
    }

    public static int countMatchingSubarrays(int[] nums, int[] pattern) {
        int len = nums.length;
        int[] input = new int[len - 1];

        for (int i = 0; i < len - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                input[i] = 1;
            } else if (nums[i] == nums[i + 1]) {
                input[i] = 0;
            } else {
                input[i] = -1;
            }
        }

        return KMP.search(input, pattern);
    }

    class KMP {

        public static int search(int[] input, int[] pattern) {
            int l = input.length, p = pattern.length;
            int[] lps = new int[p];
            buildLPS(pattern, lps);
            int i = 0, j = 0, count = 0;
            while (i < l) {
                int iNum = input[i], pNum = pattern[j];
                if (iNum == pNum) {
                    i++;
                    j++;
                    if (j == p) {
                        count++;
//                    Reset the J pointer to the point where the prefix and suffix.
                        j = lps[j - 1];
                    }

                } else {
                    if (j > 0) {
//                        If there is a suffix that already exists, then point the j index to that point.
                        j = lps[j - 1];
                    } else {
//                        There is no any prefix with that
                        i = i + 1;
                    }
                }
            }
            return count;
        }

        private static void buildLPS(int[] pattern, int[] lps) {
            int len = pattern.length;
            int maxLen = 0, i = 1;
            lps[0] = 0;
            while (i < len) {
                if (pattern[i] == pattern[maxLen]) {
                    maxLen++;
                    lps[i] = maxLen;
                    i++;
                } else {
//                There is no any prefix that matches the suffix.
                    if (maxLen != 0) {
//                    Then check if there is any prefix that matches the suffix without considering the current char.
//                      And don't move the i, till you find a suffix that matches the prefix.
                        maxLen = lps[maxLen - 1];
                    } else {
                        lps[i] = 0;
//                    YOu have reached the beginning, of the pattern, and there are no any suffix that matches the prefix.
                        i++;
                    }
                }
            }
        }
    }
}
