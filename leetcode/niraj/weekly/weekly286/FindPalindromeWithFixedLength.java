package weekly.weekly286;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on:  April 2, 2022, 12:53 PM
 * Ref: https://leetcode.com/contest/weekly-contest-286
 */

public class FindPalindromeWithFixedLength {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int num : set1) {
            if (!set2.contains(num)) {
                l1.add(num);
            }
        }
        for (int num : set2) {
            if (!set1.contains(num)) {
                l2.add(num);
            }
        }
        return Arrays.asList(l1, l2);
    }

}
