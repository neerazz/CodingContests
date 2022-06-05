package weekly.weekly296;

import java.util.*;
import java.io.*;

/**
 * Created on:  Jun 04, 2022
 * Ref: https://leetcode.com/contest/weekly-contest-296/problems/partition-array-such-that-maximum-difference-is-k/
 */

public class PartitionArraySuchThatMaximumDifferenceIsK {

    public static void main(String[] args) {

    }

    public static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1;
        int start = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] - start > k){
                count++;
                start = nums[i];
            }
        }
        return count;
    }

}
