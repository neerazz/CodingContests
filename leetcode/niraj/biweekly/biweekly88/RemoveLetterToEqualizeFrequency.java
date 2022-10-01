package biweekly.biweekly88;

import java.util.*;
import java.io.*;

/**
 * Created on:  October 1, 2022, 10:32 AM
 * Ref: <a href="https://leetcode.com/contest/biweekly-contest-88">RemoveLetterToEqualizeFrequency</a>
 */

public class RemoveLetterToEqualizeFrequency {

    public static void main(String[] args) {
        System.out.println("*************************************************");
        System.out.println(equalFrequency_naive("abcc"));
        System.out.println(equalFrequency_naive("bac"));
        System.out.println(equalFrequency_naive("abbc"));
        System.out.println("*************************************************");
        System.out.println(equalFrequency("abcc"));
        System.out.println(equalFrequency("bac"));
        System.out.println(equalFrequency("abbc"));
    }

    public static boolean equalFrequency_naive(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (checkAfterRemoving(word, i)) return true;
        }
        return false;
    }

    private static boolean checkAfterRemoving(String word, int ignore) {
        int[] counts = new int[26];
        for (int i = 0; i < word.length(); i++) {
            if (i != ignore){
                counts[word.charAt(i) - 'a']++;
            }
        }
        int val = -1;
        for (int count : counts) {
            if (count != 0){
                if(val != count){
                    if(val == -1) val = count;
                    else return false;
                }
            }
        }
        return true;
    }

    public static boolean equalFrequency(String word) {
        int[] chars = new int[26];
        for (char c : word.toCharArray()) {
            chars[c - 'a']++;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int count : chars) {
            if (count != 0) {
                map.put(count, map.getOrDefault(count, 0) + 1);
                max = Math.max(max, count);
                min = Math.min(min, count);
            }
        }
        if (map.size() == 2) {
            if (min == 1 && map.get(min) == 1) return true;
            if (max == 1 && map.get(max) == 1) return true;
            if (max - 1 == min) {
                return map.get(max) == 1;
            }
            return false;
        } else if (map.size() == 1) {
            return min == 1;
        }
        return false;
    }

}
