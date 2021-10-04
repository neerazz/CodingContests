package biweekly.biweekly62;

/**
 * Created on:  Oct 02, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-62/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/
 */

public class NumberOfPairsOfStringsWithConcatenationEqualToTarget {

    public static void main(String[] args) {

    }

    public int numOfPairs(String[] nums, String target) {
        int len = nums.length, result = 0;
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                if(i == j) continue;
                String combined = nums[i] + nums[j];
                if(combined.length() == target.length() && target.equals(combined)){
                    result++;
                }
            }
        }
        return result;
    }
}
