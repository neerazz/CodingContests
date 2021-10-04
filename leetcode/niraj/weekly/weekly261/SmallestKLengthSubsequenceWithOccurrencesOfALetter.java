package weekly.weekly261;

/**
 * Created on:  Oct 03, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-261/problems/smallest-k-length-subsequence-with-occurrences-of-a-letter/
 */

public class SmallestKLengthSubsequenceWithOccurrencesOfALetter {

    public static void main(String[] args) {

    }

    public static String smallestSubString(String s, int k, char letter, int repetition) {
        String result = "";
        int p1 = 0, p2 = 0, len = s.length(), count = 0;
        while (p2 < len) {
            char c = s.charAt(p2);
            if (c == letter) count++;
            if (p2 - p1 + 1 == k) {
                if (count >= repetition) {
                    String cur = s.substring(p1, p2 + 1);
                    if (result.length() == 0 || result.compareTo(cur) > 0) {
                        result = cur;
                    }
                }
                c = s.charAt(p1++);
                if (c == letter) count--;
            }
            p2++;
        }
        return result;
    }
}
