package weekly.weekly259;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  Sep 18, 2021
 * Ref:
 */
public class LongestSubsequenceRepeatedKTimes {
    public static void main(String[] args) {

    }

    static Map<String, Integer> map;

    public static String longestSubsequenceRepeatedK(String s, int k) {
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
        return result;
    }

    static void helper(String s, int idx, String s1, String s2) {
        if (idx == s.length()) return;
        if (s1.equals(s2) && s1.length() > 0) {
            map.put(s1, map.getOrDefault(s1, 0) + 1);
        }
        helper(s, idx + 1, s1 + s.charAt(idx), s2);
        helper(s, idx + 1, s1, s2);
        helper(s, idx + 1, s1, s2 + s.charAt(idx));
    }
}
