package biweekly.biweekly122;

import java.util.*;
import java.io.*;

/**
 * Created on:  January 20, 2024, 9:30 AM
 * Ref: <a href="https://leetcode.com/contest/biweekly-contest-122">FindIfArrayCanBeSorted</a>
 */

public class FindIfArrayCanBeSorted {

    public static void main(String[] args) {
//        System.out.println(canSortArray(new int[]{1,2,3,4,5}) + " = true");
//        System.out.println(canSortArray(new int[]{11,174,254,251}) + " = true");
//        System.out.println(canSortArray(new int[]{8,4,2,30,15}) + " = true");
//        System.out.println(canSortArray(new int[]{3,16,8,4,2}) + " = false");
//        System.out.println(canSortArray(new int[]{175,231,27,92}) + " = false");
        System.out.println(canSortArray(new int[]{75,34,30}) + " = false");
    }

    public static boolean canSortArray(int[] nums) {
        if(nums.length <=1 ) return true;
        int[] sortedArray = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedArray);
        if(Arrays.equals(nums, sortedArray)){
            return true;
        }
        int len = nums.length;
        List<List<Integer>> sortedGroup = new ArrayList<>();
        List<List<Integer>> unSortedroup = new ArrayList<>();
        int prevUnsorted = -1;
        int prevSorted = -1;
        List<Integer> sorted = new ArrayList<>();
        List<Integer> unSorted = new ArrayList<>();
        for(int i =0; i<len; i++){
            int num= nums[i];
            int unSortedsetBits = getSetBits(num);
            int sortedsetBits = getSetBits(sortedArray[i]);
            if(prevUnsorted != unSortedsetBits){
                unSortedroup.add(new ArrayList<>(unSorted));
                unSorted = new ArrayList<>();
            }
            if(sortedsetBits != prevSorted){
                sortedGroup.add(new ArrayList<>(sorted));
                sorted = new ArrayList<>();
            }
            unSorted.add(num);
            sorted.add(sortedArray[i]);
            prevSorted = sortedsetBits;
            prevUnsorted = unSortedsetBits;
        }
        unSortedroup.add(new ArrayList<>(unSorted));
        sortedGroup.add(new ArrayList<>(sorted));
        if(sortedGroup.equals(unSortedroup)){
            return true;
        }
        if(sortedGroup.size() != unSortedroup.size()){
            return false;
        }
//        System.out.println("unSortedroup = " + unSortedroup);
//        System.out.println("sortedGroup = " + sortedGroup);
//        System.out.println("nums = " + Arrays.toString(nums));
        for(int i=0; i<sortedGroup.size(); i++){
            var sortedNums = sortedGroup.get(i);
            var unsortedNums = unSortedroup.get(i);
            if(sortedNums.size() != unsortedNums.size()){
                return false;
            }
            Collections.sort(unsortedNums);
            if(!sortedNums.equals(unsortedNums)){
                return false;
            }
        }
        return true;
    }

    public static int getSetBits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

}
