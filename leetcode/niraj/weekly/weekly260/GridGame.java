package weekly.weekly260;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on:  Sep 25, 2021
 * Ref: https://leetcode.com/contest/weekly-contest-260/problems/grid-game/
 */
public class GridGame {
    public static void main(String[] args) {
        System.out.println(gridGame(new int[][]{{20, 3, 20, 17, 2, 12, 15, 17, 4, 15}, {20, 10, 13, 14, 15, 5, 2, 3, 14, 3}}) + " = 63");
        System.out.println(gridGame(new int[][]{{2, 5, 4}, {1, 5, 1}}) + " = 4");
        System.out.println(gridGame(new int[][]{{3, 3, 1}, {8, 5, 2}}) + " = 4");
        System.out.println(gridGame(new int[][]{{1, 3, 1, 15}, {1, 3, 3, 1}}) + " = 7");
    }

    // https://www.youtube.com/watch?v=N4wDSOw65hI
    public static long gridGame(int[][] grid) {
//        Key observation: Robot 2 can ONLY choose the lower left part or the upper right part of the column that Rob 1 traversed.
        int len = grid.length;
        long[][] pre = new long[2][len];
        long second = Long.MAX_VALUE;
//        Calculate the prefix sum
        pre[0][0] = grid[0][0];
        pre[1][0] = grid[1][0];
        for (int i = 1; i < len; i++) {
            pre[0][i] = grid[0][i] + pre[0][i - 1];
            pre[1][i] = grid[1][i] + pre[1][i - 1];
        }
//        Then loop through the array, and see the path that robot 1 is picking, the max of remaining will be picked by robot2.
//          Remaining means: In top row: from idx+1, till end. In bottom row: 0 to idx-1;
        for (int i = 0; i < len; i++) {
            long right = i + 1 < len ? pre[0][len - 1] - pre[0][i] : 0;
            long left = i - 1 >= 0 ? pre[1][i - 1] : 0;
//            The task of robot 1 is to minimize the points that robot 2 can earn.
            long curBest = Math.max(left, right);
            second = Math.min(second, curBest);
        }
        return second;
    }

    public static long gridGame_wrong(int[][] grid) {
        int rows = 2, cols = grid[0].length;
        Path[][] dp = new Path[rows][cols];
        Path first = helper(grid, 0, 0, rows, cols, dp);
        System.out.println("Before : " + Arrays.deepToString(grid));
        markZero(grid, first.points);
        System.out.println("After : " + Arrays.deepToString(grid));
        System.out.println("first = " + first + " Sum = " + first.sum);
        dp = new Path[rows][cols];
        Path second = helper(grid, 0, 0, rows, cols, dp);
        System.out.println("second = " + second + " Sum = " + second.sum);
        return second.sum;
    }

    static void markZero(int[][] grid, List<int[]> idxs) {
        for (int[] idx : idxs) {
            grid[idx[0]][idx[1]] = 0;
        }
    }

    static Path helper(int[][] grid, int row, int col, int rows, int cols, Path[][] dp) {
        if (row == rows - 1 && col == cols - 1) {
            return new Path(grid[row][col], Arrays.asList(new int[]{row, col}));
        }
        if (row >= rows || col >= cols) return null;
        if (dp[row][col] != null) return dp[row][col];
        long sum = grid[row][col];
        List<int[]> idxs = new ArrayList<>();
        idxs.add(new int[]{row, col});
        Path right = helper(grid, row, col + 1, rows, cols, dp);
        Path down = helper(grid, row + 1, col, rows, cols, dp);
        if (right != null && down != null) {
            if (right.sum > down.sum) {
                sum += right.sum;
                idxs.addAll(right.points);
            } else {
                sum += down.sum;
                idxs.addAll(down.points);
            }
        } else if (down != null) {
            sum += down.sum;
            idxs.addAll(down.points);
        } else if (right != null) {
            sum += right.sum;
            idxs.addAll(right.points);
        }
        Path cur = new Path(sum, idxs);
        return dp[row][col] = cur;
    }

    static class Path {
        long sum;
        List<int[]> points;

        Path(long val, List<int[]> idxs) {
            sum = val;
            points = idxs;
        }

        @Override
        public String toString() {
            return points.stream().map(Arrays::toString).collect(Collectors.joining(","));
        }
    }
}
