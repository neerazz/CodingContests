package weekly.weekly381;

import java.util.Arrays;

/**
 * Created on:  January 20, 2024, 11:27 PM
 * Ref: <a href="https://leetcode.com/contest/weekly-contest-381">CountTheNumberOfHousesAtACertainDistanceI</a>
 */

public class CountTheNumberOfHousesAtACertainDistanceI {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countOfPairs(3, 1, 3)));
        System.out.println(Arrays.toString(countOfPairs(5, 2, 4)));
    }

    public static int[] countOfPairs(int n, int x, int y) {
        int[] result = new int[n];
        int[][] dist = new int[n + 1][n + 1];
        Arrays.fill(dist[0], Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0; // The distance from a house to itself is zero.
            if (i < n)
                dist[i][i + 1] = 1;  //there's a street connecting house i to house i + 1 with distance 1.
            if (i > 1)
                dist[i][i - 1] = 1; // there's a street connecting house i - 1 to house i with distance 1.

        }
        dist[x][y] = dist[y][x] = 1; // An additional street connects the house numbered x with the house numbered y.
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                    }
                }
            }
        }
//        System.out.println("---------------------------------------------------------------");
//        Arrays.stream(dist).forEach(nums -> System.out.println(Arrays.toString(nums)));
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && dist[i][j] != Integer.MAX_VALUE) {
                    result[dist[i][j] - 1] += 1;
                }
            }
        }
        return result;
    }

}
