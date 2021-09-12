package weekly.weekly258;

import java.util.*;

/**
 * Created on:  Sep 11, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-258/problems/number-of-pairs-of-interchangeable-rectangles/
 */
public class NumberOfPairsOfInterchangeableRectangles {
    public static void main(String[] args) {

    }
    public static long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Integer> map = new HashMap<>();
        long total =0;
        for(int[] rec: rectangles){
            double cur = ((double)rec[0]) / rec[1];
            int occ = map.getOrDefault(cur,0);
            map.put(cur,occ+1);
            total += occ;
        }
        return total;
    }
}
