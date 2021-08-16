package weekly.weekly254;

import java.util.Arrays;

/**
 * Created on:  Aug 15, 2021
 * Ref : https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/
 */
public class ArrayWithElementsNotEqualToAverageOfNeighbors {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArray(new int[]{1,2,5,9})));
        System.out.println(Arrays.toString(rearrangeArray(new int[]{1,3,5,7})));
    }

//    https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/discuss/1403927/JavaC%2B%2BPython-Easy-Solution
    public static int[] rearrangeArray(int[] nums) {
        int len = nums.length, i =1;
        Arrays.sort(nums);
        while(i < len){
            swap(nums, i, i-1);
            i+=2;
        }
        return nums;
    }
    static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
