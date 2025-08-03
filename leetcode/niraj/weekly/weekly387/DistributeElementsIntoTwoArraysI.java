package weekly.weekly387;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created on:  March 2, 2024, 9:34 PM
 * Ref: <a href="https://leetcode.com/contest/weekly-contest-387">DistributeElementsIntoTwoArraysI</a>
 */

public class DistributeElementsIntoTwoArraysI {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(resultArray(new int[]{5, 4, 3, 8})));
    }

    public static int[] resultArray(int[] nums) {
        LinkedList<Integer> l1 = new LinkedList<>(), l2 = new LinkedList<>();
        int len = nums.length;
        l1.add(nums[0]);
        l2.add(nums[1]);
        for (int i = 2; i < len; i++) {
            int num = nums[i];
            if (l1.getLast() > l2.getLast()) {
                l1.add(num);
            } else {
                l2.add(num);
            }
        }
        l1.addAll(l2);
        return l1.stream().mapToInt(num -> num).toArray();
    }

}
