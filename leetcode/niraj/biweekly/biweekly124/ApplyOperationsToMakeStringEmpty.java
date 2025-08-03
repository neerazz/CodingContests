package biweekly.biweekly124;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created on:  February 17, 2024, 9:30 AM
 * Ref: <a href="https://leetcode.com/contest/biweekly-contest-124">ApplyOperationsToMakeStringEmpty</a>
 */

public class ApplyOperationsToMakeStringEmpty {

    public static void main(String[] args) {

    }

    public static String lastNonEmptyString(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        int maxOcc = Integer.MIN_VALUE;
        for (char c : s.toCharArray()) {
            int occ = map.containsKey(c) ? map.remove(c) : 0;
            map.put(c, occ + 1);
            maxOcc = Math.max(maxOcc, occ + 1);
        }
        final int max = maxOcc;
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() == max)
                .map(entry -> "" + entry.getKey())
                .collect(Collectors.joining());
    }
}
