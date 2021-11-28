package weekly.weekly261;

import java.util.Arrays;

/**
 * Created on:  Oct 03, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-261/problems/find-missing-observations/
 */

public class FindMissingObservations {

    public static void main(String[] args) {

    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int[] result = new int[0];
        int s1 = 0, c1 = rolls.length;
        int c2 = n;
        for (int num : rolls) s1 += num;
        int s2 = (mean * c1) + (mean * c2) - s1;
        int div = (s1 + s2) % (c1 + c2);
        double avg = ((double) s2) / c2;
        if (div == 0 && avg >= 1 && avg <= 6) {
//                 Then try if you can form an array with s2 sum by taking c2 nubmers, by taking 1 to 6 numbers
            int[] curResult = new int[c2];
            int i = 0;
            Arrays.fill(curResult, 6);
            int curTotal = 6 * c2;
            // System.out.println("curTotal = " + curTotal + " s2 = " + s2 + " c2 = " + c2);
            while (curTotal > s2 && i < c2) {
                int diff = curTotal - s2;
                int reduce = reduce(diff);
                // System.out.println("Diff = " + diff + " reduce = " + reduce);
                curResult[i] -= reduce;
                curTotal -= reduce;
                i++;
            }
            if (curTotal == s2) return curResult;
        }
        return result;
    }

    static int reduce(int diff) {
        if (diff >= 5) return 5;
        if (diff >= 4) return 4;
        if (diff >= 3) return 3;
        if (diff >= 2) return 2;
        return 1;
    }
}
