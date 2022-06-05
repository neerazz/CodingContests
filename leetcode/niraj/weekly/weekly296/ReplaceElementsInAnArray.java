package weekly.weekly296;

import java.util.*;
import java.io.*;

/**
 * Created on:  Jun 04, 2022
 * Ref: https://leetcode.com/contest/weekly-contest-296/problems/replace-elements-in-an-array/
 */

public class ReplaceElementsInAnArray {

    public static void main(String[] args) {

    }

    /*

            [3,2,4,6]
             0 1 2 3
             i

            2 -> 1
            4 -> 2
            6 -> 3
            3 -> 0

            [1,3],[4,7],[6,1]
              i
     */

    public static int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Queue<Integer>> idxs = new HashMap<>();
        int len = nums.length;
        for(int i=0; i<len; i++){
            idxs.computeIfAbsent(nums[i], val -> new LinkedList<>()).add(i);
        }
        for(int[] ope: operations){
            int a = ope[0], b = ope[1];
            int idx = idxs.get(a).poll();
            if(idxs.get(a).isEmpty()) idxs.remove(a);
            nums[idx] = b;
            idxs.computeIfAbsent(b, val -> new LinkedList<>()).add(idx);
        }
        return nums;
    }

}
