package biweekly.biweekly61;

import java.util.*;

/**
 * Created on:  Sep 18, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-61/problems/maximum-earnings-from-taxi/
 */
public class MaximumEarningsFromTaxi {
    public static void main(String[] args) {
        System.out.println("********************* Solution 1 *****************************");
        System.out.println(maxTaxiEarnings(5, new int[][]{{2, 5, 4}, {1, 5, 1}}) + " = 7");
        System.out.println(maxTaxiEarnings(20, new int[][]{{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}}) + " = 20");
        System.out.println(maxTaxiEarnings(5, new int[][]{{2, 3, 4}, {4, 5, 1}}) + " = 7");
        System.out.println(maxTaxiEarnings(10, new int[][]{{2, 3, 6}, {8, 9, 8}, {5, 9, 7}, {8, 9, 1}, {2, 9, 2}, {9, 10, 6}, {7, 10, 10}, {6, 7, 9}, {4, 9, 7}, {2, 3, 1}}) + " = 33");
        System.out.println("********************* Solution 2 *****************************");
        System.out.println(maxTaxiEarnings_dp_bottom_up(5, new int[][]{{2, 5, 4}, {1, 5, 1}}) + " = 7");
        System.out.println(maxTaxiEarnings_dp_bottom_up(20, new int[][]{{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}}) + " = 20");
        System.out.println(maxTaxiEarnings_dp_bottom_up(5, new int[][]{{2, 3, 4}, {4, 5, 1}}) + " = 7");
        System.out.println(maxTaxiEarnings_dp_bottom_up(10, new int[][]{{2, 3, 6}, {8, 9, 8}, {5, 9, 7}, {8, 9, 1}, {2, 9, 2}, {9, 10, 6}, {7, 10, 10}, {6, 7, 9}, {4, 9, 7}, {2, 3, 1}}) + " = 33");
    }

    public static long maxTaxiEarnings(int n, int[][] rides) {
        int len = rides.length;
        Arrays.sort(rides, (r1, r2) -> r1[0] == r2[0] ? Integer.compare(r1[1], r2[1]) : Integer.compare(r1[0], r2[0]));
        long[] dp = new long[len];
        long best = 0;
        for (int i = 0; i < len; i++) {
            int[] ride = rides[i];
            long curProfit = ride[1] - ride[0] + ride[2];
            dp[i] = curProfit;
            for (int j = i - 1; j >= 0; j--) {
//                 if the jth ride ends on or before ith ride.
                if (rides[j][1] <= rides[i][0]) dp[i] = Math.max(dp[i], dp[j] + curProfit);
//                else dp[i] = Math.max(dp[i], dp[j]);
            }
            best = Math.max(best, dp[i]);
        }
//        System.out.println("rides = " + Arrays.deepToString(rides));
//        System.out.println("dp = " + Arrays.toString(dp));
        return best;
    }

    public static long maxTaxiEarnings_dp_bottom_up(int n, int[][] rides) {
        int len = rides.length;
        Arrays.sort(rides, (r1, r2) -> Integer.compare(r1[0], r2[0]));
        long[] dp = new long[n + 1];
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int[] ride = rides[i];
            map.putIfAbsent(ride[0], new ArrayList<>());
            map.get(ride[0]).add(new int[]{ride[1], i});
        }
        long best = 0;
        for (int i = n - 1; i >= 0; i--) {
//            Get all rides starting at this point and find the best so far.
            for (int[] ends : map.getOrDefault(i, new ArrayList<>())) {
                int end = ends[0], idx = ends[1];
                long profit = rides[idx][1] - rides[idx][0] + rides[idx][2];
                dp[i] = Math.max(dp[i], dp[end] + profit);
            }
//            Find teh best If you don't take any ride at this point, and take the pre best ride.
            dp[i] = Math.max(dp[i], dp[i + 1]);
            best = Math.max(dp[i], best);
        }
//        System.out.println("rides = " + Arrays.deepToString(rides));
//        System.out.println("dp = " + Arrays.toString(dp));
        return best;
    }
}
