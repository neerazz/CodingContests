package biweekly.biweekly124;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on:  February 17, 2024, 9:30 AM
 * Ref: <a href="https://leetcode.com/contest/biweekly-contest-124">MaximizeConsecutiveElementsInAnArrayAfterModification</a>
 */

public class MaximizeConsecutiveElementsInAnArrayAfterModification {

    public static void main(String[] args) {
//        System.out.println(maxSelectedElements(new int[]{2, 1, 5, 1, 1}) + " = 3");
        System.out.println(maxSelectedElements(new int[]{1, 4, 7, 10}) + " = 1");
    }

    public static int maxSelectedElements(int[] nums) {
        int max = 0;
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int op1 = map.getOrDefault(num, 0);
            int op2 = map.getOrDefault(num - 1, 0);
            map.put(num + 1, op1 + 1);
            map.put(num, op2 + 1);
            max = Math.max(max, Math.max(op1 + 1, op2 + 1));
        }
        return max;
    }

}
