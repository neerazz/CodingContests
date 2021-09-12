package weekly.weekly258;

/**
 * Created on:  Sep 11, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-258/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/
 */
public class MaximumProductOfTheLengthOfTwoPalindromicSubsequences {
    public static void main(String[] args) {
        System.out.println(maxProduct("leetcodecom"));
        System.out.println(maxProduct("accbcaxxcxx"));
    }

    static int max;

    public static int maxProduct(String s) {
        max = 0;
        helper(s, "", "", 0);
        return max;
    }

    private static void helper(String s, String p1, String p2, int i) {
        if (i >= s.length()){
            if (isPalindrome(p1) && isPalindrome(p2)) {
                max = Math.max(p1.length() * p2.length(), max);
            }
        }
        helper(s, p1 + s.charAt(i), p2, i + 1);
        helper(s, p1, p2 + s.charAt(i), i + 1);
        helper(s, p1, p2, i + 1);
    }

    private static boolean isPalindrome(String str) {
        int start = 0, end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }
}
