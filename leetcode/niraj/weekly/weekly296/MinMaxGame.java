package weekly.weekly296;

import java.util.*;
import java.io.*;

/**
 * Created on:  Jun 04, 2022
 * Ref: https://leetcode.com/contest/weekly-contest-296/problems/min-max-game/
 */

public class MinMaxGame {

    public static void main(String[] args) {
        System.out.println(minMaxGame(new int[]{1, 3, 5, 2, 4, 8, 2, 2}));
        System.out.println(minMaxGame(new int[]{3}));
        System.out.println(minMaxGame(new int[]{70, 38, 21, 22}));
    }

    public static int minMaxGame(List<Integer> list) {
        int len = list.size();
        if (len == 1) {
            return list.get(0);
        } else {
            int newIdx = 0;
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < len; i += 2) {
                int j = i + 1;
                if (j < len) {
                    if (newIdx % 2 == 0) {
                        nums.add(Math.min(list.get(i), list.get(j)));
                    } else {
                        nums.add(Math.max(list.get(i), list.get(j)));
                    }
                }
                newIdx++;
            }
            return minMaxGame(nums);
        }
    }

    public static int minMaxGame(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) list.add(n);
        return minMaxGame(list);
    }

}
