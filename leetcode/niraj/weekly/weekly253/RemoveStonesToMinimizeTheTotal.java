package weekly.weekly253;

import java.util.PriorityQueue;

/**
 * Created on:  Aug 08, 2021
 * Ref : https://leetcode.com/contest/weekly-contest-253/problems/remove-stones-to-minimize-the-total/
 */
public class RemoveStonesToMinimizeTheTotal {
    public static void main(String[] args) {

    }
    public static int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1,v2) -> Integer.compare(v2, v1));
        for(int num: piles) pq.add(num);
        while(k-- >0 && !pq.isEmpty()){
            int poll = pq.poll();
            int modified = poll - (poll/2);
            if(modified > 0) pq.add(modified);
        }
        int total = 0;
        while(!pq.isEmpty()){
            total += pq.poll();
        }
        return total;
    }
}
