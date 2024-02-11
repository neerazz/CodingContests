package weekly.weekly384;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created on:  February 11, 2024, 11:44 AM
 * Ref: <a href="https://leetcode.com/contest/weekly-contest-384">MaximumPalindromesAfterOperations</a>
 */

public class MaximumPalindromesAfterOperations {


    public static void main(String[] args) {
//        System.out.println(maxPalindromesAfterOperations(new String[]{"abbb", "ba", "aa"}) + " = 3");
//        System.out.println(maxPalindromesAfterOperations(new String[]{"aab", "bca"}) + " = 2");
//        System.out.println(maxPalindromesAfterOperations(new String[]{"aagha", "bc"}) + " = 1");
        System.out.println(maxPalindromesAfterOperations(new String[]{"cd", "ef", "a"}) + " = 1");
    }

    public static int maxPalindromesAfterOperations(String[] words) {
        int len = words.length;
        int[] counts = new int[26];
        List<Integer> lens = new ArrayList<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts[c - 'a']++;
            }
            lens.add(word.length());
        }
        Collections.sort(lens);
        int pairs = 0;
//        Count how many pairs we can create.
        for (int count : counts) {
            pairs += count / 2;
        }

//        Now loop through all the words where we can make a palindrome.
//          To make a palindrome, we have reduced those many pairs.
        for (int i = 0; i < len; i++) {
            pairs -= lens.get(i) / 2;
            if (pairs < 0) {
                return i;
//                If there are no sufficient pairs, then we cannot form any more palindrome.
            }
        }
        return len;
    }

}