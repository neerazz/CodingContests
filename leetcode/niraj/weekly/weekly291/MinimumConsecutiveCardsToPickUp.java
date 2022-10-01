package weekly.weekly291;

import java.util.*;
import java.io.*;

/**
 * Created on:  August 29, 2022, 5:07 PM
 * Ref: <a href="https://leetcode.com/contest/weekly-contest-291">...</a>
 */

public class MinimumConsecutiveCardsToPickUp {

    public static void main(String[] args) {

    }

    /*
            3,4,2,3,4,7
            0 1 2 3 4 5
                  i
            olen = 3-0+1=4
            m = 3,0
            4,1
            2,2
     */
    public static int minimumCardPickup(int[] cards) {
        int outLen = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            int num = cards[i];
            if (map.containsKey(num)) {
                int dist = i - map.get(num) + 1;
                outLen = Math.min(outLen, dist);
            }
            map.put(num, i);
        }
        return outLen == Integer.MAX_VALUE ? -1 : outLen;
    }

}
