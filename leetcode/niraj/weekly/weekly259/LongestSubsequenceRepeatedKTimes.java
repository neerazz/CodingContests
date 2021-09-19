package weekly.weekly259;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created on:  Sep 18, 2021
 * Ref: https://leetcode.com/problems/longest-subsequence-repeated-k-times/
 */
public class LongestSubsequenceRepeatedKTimes {
    public static void main(String[] args) {
        System.out.println(longestSubsequenceRepeatedK("letsleetcode", 2));
    }

    // https://leetcode.com/problems/longest-subsequence-repeated-k-times/discuss/1471911/Java-BFS-O(n-*-2-8)-with-detailed-explanation
    public static String longestSubsequenceRepeatedK(String s, int k) {
        String result = "";
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < 26; j++) {
                    String next = cur + (char) ('a' + j);
//                    Check if the current substring can occur k times.
                    if (hasSub(s, next, k)) {
                        result = next;
                        queue.add(next);
                    }
                }
            }
        }
        return result;
    }

    private static boolean hasSub(String s, String sub, int k) {
        int count = 0;
        int j = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == sub.charAt(j)) {
                j++;
//                One round of sub string is found.
                if (j == sub.length()) {
                    count++;
                    j = 0;
                }
                if (count == k) return true;
            }
        }
        return false;
    }

    static Map<String, Integer> map;

    public static String longestSubsequenceRepeatedK_naive(String s, int k) {
        map = new HashMap<>();
        helper(s, 0, "", "");
        String result = "";
        for (String str : map.keySet()) {
            if (map.get(str) == k) {
                if (result.length() < str.length() || str.compareTo(result) > 0) {
                    result = str;
                }
            }
        }
        System.out.println("map = " + map);
        return result;
    }

    static void helper(String s, int idx, String s1, String s2) {
        System.out.println("s1 = " + s1 + "\ts2 = " + s2);
        if (idx == s.length()) return;
        if (s1.equals(s2) && s1.length() > 0) {
            map.put(s1, map.getOrDefault(s1, 0) + 1);
        }
        helper(s, idx + 1, s1 + s.charAt(idx), s2);
        helper(s, idx + 1, s1, s2);
        helper(s, idx + 1, s1, s2 + s.charAt(idx));
    }
}
