package biweekly.biweekly59;

import java.util.*;

/**
 * Created on:  Aug 21, 2021
 * Ref : https://leetcode.com/contest/biweekly-contest-59/problems/number-of-ways-to-arrive-at-destination/
 */
public class NumberOfWaysToArriveAtDestination {
    public static void main(String[] args) {
        System.out.println(countPaths(7, new int[][]{{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}}));
    }

    static int mod = 1_000_000_007;

    public static int countPaths(int n, int[][] roads) {
        Map<Integer, List<long[]>> map = new HashMap<>();
        for (int[] road : roads) {
            int from = road[0], to = road[1], time = road[2];
            map.computeIfAbsent(from, val -> new ArrayList<>()).add(new long[]{to, time});
            map.computeIfAbsent(to, val -> new ArrayList<>()).add(new long[]{from, time});
        }
        long[][] dp = new long[n][2];
//        d[i], the shortest distance from i to end and number of possible path from i to start.
        for (int i = 1; i < n; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
//        time taken to reach 0 from zero is 0, and there is one possibility.
        dp[0][0] = 0;
        dp[0][1] = 1;
        PriorityQueue<long[]> pq = new PriorityQueue<>((v1, v2) -> Long.compare(v1[2], v2[2]));
        add(0, pq, map, 0);
        while(!pq.isEmpty()){
            long[] poll = pq.poll();
            int src = (int) poll[0], dest = (int) poll[1];
            long dist = poll[2];
//            This is the key.
//                If you can reach the dest point in with the current time then, this ia valid shortest path.
            if(dist <= dp[dest][0]){
                dp[dest][1] +=  dp[src][1];
                dp[dest][1] %= mod;
            }
//                If you can reach the destination in less than the previous best then add the dest to pq, and start exploring it again.
            if(dist < dp[dest][0]){
                dp[dest][0] = dist;
                add(dest, pq, map, dist);
            }
        }
//        return the number of possibility of reaching n-1 point in the shortest distance.
        return (int) (dp[n - 1][1] % mod);
    }

    private static void add(int cur, PriorityQueue<long[]> pq, Map<Integer, List<long[]>> map, long soFarDist) {
        for (long[] des : map.getOrDefault(cur, new ArrayList<>())) {
            pq.add(new long[]{cur, des[0], des[1] + soFarDist});
        }
    }
}
