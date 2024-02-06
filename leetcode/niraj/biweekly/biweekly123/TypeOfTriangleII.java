package biweekly.biweekly123;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on:  February 3, 2024, 9:33 AM
 * Ref: <a href="https://leetcode.com/contest/biweekly-contest-123">TypeOfTriangleII</a>
 */

public class TypeOfTriangleII {

    public static void main(String[] args) {
        System.out.println(triangleType(new int[]{8, 4, 2}) + " = none");
        System.out.println(triangleType(new int[]{8, 4, 4}) + " = none");
    }

    public static String triangleType(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        int sum = 0, count = 0, max = 0;
        for (int num : nums) {
            if (count == 2) {
                max = num;
            } else {
                sum += num;
            }
            count++;
            set.add(num);
        }
        if (sum > max) {
            if (set.size() == 1) {
                return "equilateral";
            } else if (set.size() == 2) {
                return "isosceles";
            } else {
                return "scalene";
            }
        } else {
            return "none";
        }
    }

}
