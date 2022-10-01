package biweekly.biweekly88;

import java.util.*;
import java.io.*;

/**
 * Created on:  October 1, 2022, 10:32 AM
 * Ref: <a href="https://leetcode.com/contest/biweekly-contest-88">BitwiseXOROfAllPairings</a>
 */

public class BitwiseXOROfAllPairings {

    public static void main(String[] args) {

    }

    public static int xorAllNums_optimal(int[] nums1, int[] nums2) {
        int l1 = nums1.length % 2, l2 = nums2.length % 2;
        int result = 0;
        if (l1 > 0) {
            for (int x : nums2) {
                result ^= x;
            }
        }
        if (l2 > 0) {
            for (int x : nums1) {
                result ^= x;
            }
        }
        return result;
    }

    public static int xorAllNums(int[] nums1, int[] nums2) {
        int result = 0;
        for (int j : nums1) {
            for (int k : nums2) {
                result ^= j ^ k;
            }
        }
        return result;
    }

}
