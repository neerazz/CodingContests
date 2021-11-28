package weekly.weekly269;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on:  Nov 27, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-269/problems/find-target-indices-after-sorting-array/
 */

public class FindTargetIndicesAfterSortingArray {

    public static void main(String[] args) {

    }

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] == target) result.add(i);
        }
        return result;
    }

}
