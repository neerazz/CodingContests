package biweekly.biweekly122;

import java.util.*;
import java.io.*;

/**
 * Created on:  January 20, 2024, 9:30 AM
 * Ref: <a href="https://leetcode.com/contest/biweekly-contest-122">DivideAnArrayIntoSubarraysWithMinimumCostI</a>
 */

public class DivideAnArrayIntoSubarraysWithMinimumCostI {

    public static void main(String[] args) {

    }

    public static int minimumCost(int[] nums) {
        int result = Integer.MAX_VALUE;
        for(int i= 1; i<nums.length-1; i++){
            for (int j = i+1; j<nums.length; j++){
                int sum = nums[0] + nums[i] + nums[j];
                result = Math.min(result, sum);
            }
        }
        return result;
    }

}
