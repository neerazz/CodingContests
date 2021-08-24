package weekly.weekly255;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created on:  Aug 21, 2021
 * Ref : https://leetcode.com/contest/weekly-contest-255/problems/minimize-the-difference-between-target-and-chosen-elements/
 */
public class MinimizeTheDifferenceBetweenTargetAndChosenElements {
    public static void main(String[] args) {
        System.out.println(minimizeTheDifference_dp(new int[][]{{1, 2, 9, 8, 7}}, 6) + " = 1");
        System.out.println(minimizeTheDifference_dp(new int[][]{{1},{2},{3}}, 100) + " = 94");
        System.out.println(minimizeTheDifference_dp(new int[][]{{65}, {45}, {45}, {69}, {55}, {60}, {29}, {25}, {16}, {5}, {62}, {16}, {29}, {19}, {34}, {2}, {24}, {32}, {66}, {62}, {60}, {46}, {42}, {37}, {51}, {4}, {41}, {4}, {66}, {20}, {9}, {4}, {66}, {6}, {56}, {10}, {51}, {44}, {7}, {8}, {5}, {44}, {28}, {7}, {10}, {7}, {24}, {62}, {19}, {14}, {45}, {68}, {9}, {14}, {51}, {28}, {8}, {57}, {59}, {6}, {54}, {8}, {19}, {16}, {63}, {45}, {33}, {15}, {33}, {67}},
                6) + " = 1510");
        System.out.println(minimizeTheDifference_dp(new int[][]{{5, 14, 29, 10, 45, 35, 41, 30, 26, 31, 46, 18, 40, 15, 28, 30, 16, 41, 32, 41, 18, 14, 44, 31, 25, 2, 17, 34, 17, 20, 21, 14, 37, 41, 27, 4}, {6, 7, 12, 11, 22, 19, 35, 15, 42, 13, 49, 41, 5, 7, 33, 17, 34, 29, 22, 33, 49, 10, 13, 15, 8, 20, 34, 32, 49, 31, 30, 41, 45, 50, 33, 22}, {19, 10, 30, 29, 2, 28, 34, 26, 12, 15, 39, 21, 34, 27, 19, 29, 9, 18, 24, 42, 27, 44, 44, 43, 3, 11, 50, 24, 45, 44, 34, 37, 14, 38, 38, 28}, {22, 35, 14, 18, 44, 9, 50, 44, 20, 38, 39, 16, 41, 37, 5, 1, 44, 35, 45, 47, 50, 32, 1, 35, 13, 1, 5, 36, 42, 22, 11, 26, 12, 39, 38, 49}, {20, 27, 21, 10, 38, 41, 1, 44, 34, 38, 50, 30, 2, 25, 48, 11, 12, 16, 43, 8, 30, 14, 22, 15, 6, 20, 4, 7, 18, 28, 7, 45, 7, 13, 46, 25}, {13, 27, 37, 46, 16, 31, 41, 42, 14, 5, 9, 36, 6, 24, 47, 13, 14, 23, 45, 31, 23, 18, 12, 29, 49, 41, 33, 18, 35, 38, 6, 2, 34, 35, 10, 22}, {36, 16, 16, 15, 16, 49, 27, 46, 28, 19, 9, 44, 20, 43, 1, 28, 33, 43, 41, 30, 9, 20, 22, 34, 38, 7, 10, 34, 45, 44, 26, 39, 24, 3, 45, 27}, {32, 25, 49, 48, 6, 6, 32, 30, 31, 45, 3, 45, 43, 12, 16, 48, 23, 26, 21, 44, 40, 21, 39, 17, 38, 43, 49, 47, 46, 36, 30, 38, 27, 27, 45, 48}, {9, 34, 40, 10, 13, 48, 14, 41, 14, 7, 3, 4, 27, 5, 26, 35, 30, 12, 21, 25, 9, 50, 1, 2, 26, 27, 39, 10, 12, 50, 36, 20, 50, 10, 7, 8}, {12, 14, 14, 45, 13, 8, 22, 3, 16, 22, 3, 33, 47, 49, 43, 35, 10, 22, 3, 34, 46, 19, 16, 9, 36, 16, 48, 16, 45, 29, 4, 35, 33, 26, 20, 45}, {32, 34, 3, 12, 37, 16, 6, 23, 2, 31, 39, 2, 49, 28, 8, 15, 25, 22, 40, 45, 31, 7, 16, 30, 5, 39, 42, 33, 35, 15, 10, 2, 31, 29, 21, 40}, {29, 31, 29, 50, 20, 9, 40, 40, 19, 38, 32, 20, 5, 7, 2, 28, 48, 8, 21, 4, 20, 50, 2, 14, 37, 10, 23, 42, 41, 23, 42, 10, 6, 18, 40, 8}, {5, 10, 37, 16, 1, 19, 38, 11, 46, 3, 25, 23, 6, 20, 32, 42, 30, 11, 49, 38, 4, 49, 16, 26, 47, 17, 45, 49, 50, 22, 12, 37, 37, 30, 22, 6}, {19, 20, 14, 5, 5, 22, 33, 31, 36, 1, 44, 9, 42, 24, 24, 19, 49, 31, 33, 1, 10, 43, 38, 23, 46, 35, 38, 11, 18, 17, 17, 10, 43, 50, 2, 27}, {9, 26, 25, 48, 8, 33, 41, 23, 27, 21, 17, 21, 32, 3, 20, 26, 19, 5, 5, 50, 42, 47, 31, 9, 12, 43, 8, 27, 36, 17, 34, 25, 2, 41, 29, 48}, {3, 9, 13, 1, 9, 29, 47, 32, 2, 16, 47, 36, 47, 47, 47, 49, 42, 48, 16, 41, 34, 41, 50, 5, 46, 20, 38, 10, 14, 35, 30, 14, 19, 31, 47, 5}, {10, 32, 4, 16, 17, 18, 39, 2, 4, 37, 22, 34, 17, 25, 29, 33, 49, 46, 41, 1, 23, 40, 44, 23, 15, 17, 1, 4, 23, 26, 2, 39, 33, 16, 29, 8}, {50, 42, 30, 2, 45, 36, 29, 22, 11, 29, 21, 50, 40, 19, 45, 39, 21, 18, 10, 46, 35, 36, 26, 20, 4, 18, 42, 21, 33, 46, 36, 27, 36, 19, 43, 11}, {6, 44, 9, 20, 37, 26, 24, 36, 32, 5, 49, 40, 17, 44, 30, 19, 8, 44, 35, 38, 50, 45, 18, 20, 7, 39, 35, 47, 39, 7, 49, 39, 27, 47, 41, 41}, {3, 49, 2, 38, 27, 41, 14, 21, 13, 30, 36, 19, 45, 30, 22, 24, 26, 22, 1, 36, 34, 41, 43, 31, 16, 31, 48, 13, 42, 36, 29, 44, 40, 39, 47, 40}, {14, 8, 26, 35, 10, 26, 38, 25, 11, 38, 44, 26, 21, 50, 1, 25, 27, 41, 20, 4, 20, 7, 16, 36, 48, 17, 19, 1, 47, 3, 22, 2, 24, 19, 45, 46}, {49, 25, 45, 49, 28, 15, 10, 49, 38, 3, 42, 34, 32, 37, 29, 49, 12, 13, 28, 31, 35, 36, 4, 7, 5, 28, 20, 28, 21, 18, 35, 13, 41, 35, 48, 28}, {6, 42, 8, 43, 13, 1, 50, 45, 29, 6, 27, 40, 12, 43, 40, 38, 44, 5, 46, 23, 27, 35, 31, 40, 37, 25, 18, 1, 47, 13, 1, 31, 36, 4, 9, 38}, {34, 26, 31, 41, 28, 24, 11, 47, 13, 19, 26, 27, 4, 27, 27, 13, 26, 33, 24, 36, 9, 32, 35, 34, 49, 13, 45, 22, 39, 6, 24, 38, 3, 8, 9, 44}, {38, 11, 30, 18, 29, 50, 7, 8, 38, 21, 1, 32, 37, 20, 48, 17, 34, 14, 13, 19, 29, 12, 13, 48, 25, 47, 17, 35, 46, 38, 45, 40, 4, 22, 2, 24}, {20, 27, 20, 42, 30, 43, 23, 50, 45, 18, 14, 41, 38, 25, 11, 19, 29, 41, 24, 8, 30, 26, 9, 47, 24, 47, 42, 35, 32, 2, 13, 47, 19, 37, 3, 41}, {1, 43, 5, 39, 9, 6, 1, 2, 13, 47, 12, 33, 1, 23, 36, 23, 6, 6, 31, 44, 46, 44, 15, 27, 47, 18, 16, 40, 27, 4, 11, 46, 23, 16, 20, 28}, {26, 28, 50, 13, 12, 26, 49, 32, 18, 12, 26, 47, 25, 15, 14, 7, 35, 27, 32, 8, 3, 7, 16, 32, 12, 42, 16, 10, 24, 41, 4, 23, 1, 35, 19, 16}, {13, 19, 12, 2, 17, 31, 39, 34, 37, 31, 44, 12, 41, 28, 48, 11, 6, 3, 14, 25, 29, 6, 22, 9, 5, 39, 41, 20, 26, 50, 18, 10, 35, 34, 8, 35}, {25, 49, 12, 23, 10, 34, 22, 26, 38, 6, 11, 8, 46, 18, 29, 50, 38, 16, 16, 26, 18, 12, 14, 50, 25, 42, 34, 42, 21, 5, 20, 46, 32, 41, 50, 17}, {49, 1, 28, 19, 19, 18, 44, 2, 43, 45, 17, 18, 50, 37, 31, 4, 40, 43, 44, 26, 13, 46, 6, 39, 27, 21, 8, 17, 34, 24, 34, 8, 21, 19, 16, 9}, {6, 38, 47, 35, 6, 28, 10, 11, 49, 10, 27, 31, 37, 24, 35, 5, 43, 28, 22, 5, 40, 5, 30, 11, 27, 16, 45, 36, 22, 28, 41, 34, 32, 42, 50, 42}, {16, 23, 43, 32, 49, 39, 1, 18, 34, 14, 4, 21, 45, 38, 20, 35, 16, 24, 4, 29, 19, 6, 24, 28, 42, 46, 39, 12, 10, 7, 34, 14, 49, 16, 33, 45}, {38, 15, 29, 20, 44, 35, 48, 35, 23, 13, 37, 4, 12, 47, 21, 36, 24, 22, 41, 27, 23, 39, 32, 12, 38, 45, 50, 13, 20, 28, 23, 13, 47, 38, 18, 39}, {14, 50, 34, 29, 36, 30, 44, 15, 49, 32, 41, 40, 22, 39, 50, 19, 22, 35, 38, 24, 1, 29, 44, 28, 21, 50, 2, 17, 14, 26, 1, 34, 14, 3, 32, 45}, {12, 24, 30, 25, 38, 49, 31, 48, 36, 2, 14, 16, 22, 8, 14, 11, 15, 46, 16, 50, 20, 46, 7, 35, 9, 39, 40, 3, 10, 50, 1, 48, 30, 38, 4, 41}},
                349) + " = 0");
        System.out.println(minimizeTheDifference_dp(new int[][]{{18, 49, 33, 11, 40, 27, 15, 39, 17, 3, 44, 2}, {38, 31, 7, 3, 35, 3, 18, 41, 30, 37, 38, 23}, {33, 18, 8, 31, 8, 49, 36, 45, 13, 21, 34, 37}, {35, 28, 42, 38, 6, 7, 35, 6, 3, 32, 36, 7}, {39, 7, 50, 23, 11, 33, 15, 31, 5, 21, 29, 25}, {40, 16, 39, 3, 16, 29, 30, 34, 12, 45, 28, 13}, {3, 38, 32, 30, 7, 25, 44, 8, 43, 16, 18, 15}, {30, 18, 20, 18, 32, 16, 46, 36, 20, 28, 30, 16}, {19, 28, 37, 35, 25, 29, 50, 27, 37, 46, 17, 43}, {42, 36, 41, 33, 3, 41, 35, 17, 48, 41, 35, 27}, {14, 44, 17, 15, 41, 34, 28, 37, 32, 46, 42, 37}, {41, 2, 17, 27, 3, 26, 5, 30, 38, 24, 11, 30}, {44, 19, 25, 8, 4, 25, 36, 35, 45, 4, 43, 6}, {10, 16, 17, 16, 11, 34, 44, 31, 41, 40, 29, 10}, {37, 25, 46, 5, 14, 16, 1, 40, 18, 28, 20, 12}, {24, 25, 39, 31, 39, 47, 4, 19, 13, 35, 42, 46}, {13, 8, 34, 20, 19, 19, 19, 8, 38, 39, 45, 37}, {44, 42, 9, 25, 16, 12, 37, 41, 4, 38, 17, 32}, {14, 7, 20, 7, 39, 18, 4, 46, 33, 10, 32, 16}, {2, 41, 24, 23, 22, 30, 28, 18, 28, 1, 8, 5}, {14, 39, 46, 49, 7, 28, 18, 32, 31, 13, 30, 42}, {3, 21, 23, 18, 14, 41, 1, 18, 28, 36, 47, 20}, {47, 32, 41, 12, 18, 6, 48, 14, 4, 9, 24, 48}, {31, 37, 50, 11, 33, 32, 40, 9, 13, 17, 13, 30}, {42, 9, 35, 24, 50, 48, 5, 25, 37, 3, 44, 21}, {45, 31, 29, 4, 25, 17, 36, 41, 4, 39, 40, 24}, {16, 30, 32, 13, 11, 33, 28, 14, 20, 1, 18, 20}, {49, 39, 10, 39, 19, 30, 37, 2, 7, 16, 50, 2}, {14, 39, 12, 4, 28, 15, 22, 30, 15, 39, 18, 3}, {2, 32, 24, 34, 1, 39, 28, 20, 1, 22, 31, 2}, {1, 34, 43, 8, 24, 7, 9, 34, 32, 29, 50, 39}, {45, 24, 29, 23, 43, 44, 4, 26, 1, 49, 3, 28}, {29, 9, 6, 40, 2, 37, 49, 25, 13, 9, 43, 9}, {37, 40, 14, 9, 19, 36, 47, 4, 7, 30, 15, 25}, {44, 17, 9, 37, 14, 34, 31, 22, 38, 28, 14, 12}, {2, 28, 22, 26, 29, 26, 28, 32, 22, 27, 15, 35}, {37, 39, 10, 29, 26, 47, 32, 26, 9, 38, 48, 40}},
                119) + " = 59");
    }

    public static int minimizeTheDifference_dp(int[][] mat, int target) {
        int rows = mat.length, cols = rows > 0 ? mat[0].length : 0, max =0;
        for (int[] row : mat){
            Arrays.sort(row);
            max = Math.max(max, row[row.length-1]);
        }
        int minAllowed = Math.max(max, target) * rows * -1, maxAllowed = Math.max(max, target) * rows;
        Integer[][] dp = new Integer[rows][maxAllowed - minAllowed + 1];
//        Map<String,Integer> dp = new HashMap<>();
        int closet = helper(mat, 0, rows, cols, target, dp, minAllowed, maxAllowed);
//        Arrays.stream(dp).forEach(row -> System.out.println(Arrays.toString(row)));
        return Math.abs(target - closet);
    }

    //    static int helper(int[][] mat, int row, int rows, int cols, int target, Map<String,Integer> dp, int min, int max) {
    static int helper(int[][] mat, int row, int rows, int cols, int target, Integer[][] dp, int min, int max) {
        if (row == rows) return 0;
        if (target < min || target > max) return Integer.MAX_VALUE;
//        String key = String.format("%d, %d", row, target);
//        if(dp.containsKey(key)) return dp.get(key);
        int key = target - min;
//        if(key < 0 || key > max-min+1) return Integer.MAX_VALUE;
        if (dp[row][key] != null) return dp[row][key];
        int curClosest = Integer.MAX_VALUE;
        for (int col = 0; col < cols; col++) {
            int next = helper(mat, row + 1, rows, cols, target - mat[row][col], dp, min, max);
            if (next != Integer.MAX_VALUE) {
                int closest = mat[row][col] + next;
                if (curClosest == Integer.MAX_VALUE || Math.abs(target - curClosest) > Math.abs(target - closest)) {
                    curClosest = closest;
                }
            }
        }
//        dp.put(key, curClosest);
//        return curClosest;
        return dp[row][key] = curClosest;
    }
}
