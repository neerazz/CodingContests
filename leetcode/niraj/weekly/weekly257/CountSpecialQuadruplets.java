package weekly.weekly257;

import java.util.*;

/**
 * Created on:  Sep 12, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-257/problems/count-special-quadruplets/
 */
public class CountSpecialQuadruplets {
    public static void main(String[] args) {

    }
    public int countQuadruplets(int[] nums) {
        int len = nums.length;
        int count =0;
        for(int a=0; a<len; a++){
            for(int b =a+1; b<len; b++){
                for(int c=b+1;c<len; c++){
                    for(int d=c+1; d<len; d++){
                        if(nums[a] + nums[b] + nums[c] == nums[d]) count++;
                    }
                }
            }
        }
        return count;
    }
}
