package weekly.weekly286;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created on:  April 2, 2022, 12:53 PM
 * Ref: https://leetcode.com/contest/weekly-contest-286
 */

public class MaximumValueOfKCoinsFromPiles {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(kthPalindrome(new int[]{1, 2, 3, 4, 5, 90}, 3)));
        System.out.println(Arrays.toString(kthPalindrome(new int[]{2, 4, 6}, 4)));
        System.out.println(Arrays.toString(kthPalindrome(new int[]{2, 201429812, 8, 520498110, 492711727, 339882032, 462074369, 9, 7, 6}, 1)));
    }

    public static long[] kthPalindrome(int[] queries, int intLength) {
        int maxCount = Arrays.stream(queries).max().getAsInt();
        List<Long> palindromes = getPalingDome(intLength, intLength, maxCount + 1);
        int len = queries.length;
        long[] result = new long[len];
        for (int i = 0; i < len; i++) {
            int queryIndex = queries[i]-1;
            if (palindromes.size() > queryIndex) {
                result[i] = palindromes.get(queryIndex);
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    private static List<Long> getPalingDome(int intLength, int requiredLen, int maxCount) {
        if (intLength == 1) {
            return Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L);
        } else if (intLength == 2) {
            return Arrays.asList(11L, 22L, 33L, 44L, 55L, 66L, 77L, 88L, 99L);
        } else {
            List<Long> pre = getPalingDome(intLength - 2, requiredLen, maxCount);
            List<Long> cur = new ArrayList<>();
            for (int i = 1; i <= 9; i++) {
                if (intLength == 4 || intLength == 3) {
                    long curNum = i * ((long) Math.pow(10, intLength - 1)) + i;
                    cur.add(curNum);
                    if (intLength == requiredLen && cur.size() == maxCount) return cur;
                }
                for (long num : pre) {
                    long curNum = i * ((long) Math.pow(10, intLength - 1)) + num * 10 + i;
                    cur.add(curNum);
                    if (intLength == requiredLen && cur.size() == maxCount) return cur;
                }
            }
            return cur;
        }
    }

}
