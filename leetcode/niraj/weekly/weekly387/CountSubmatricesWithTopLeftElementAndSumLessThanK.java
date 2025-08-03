package weekly.weekly387;

/**
 * Created on:  March 2, 2024, 9:34 PM
 * Ref: <a href="https://leetcode.com/contest/weekly-contest-387">CountSubmatricesWithTopLeftElementAndSumLessThanK</a>
 */

public class CountSubmatricesWithTopLeftElementAndSumLessThanK {

    public static void main(String[] args) {
        System.out.println(countSubmatrices(new int[][]{
                {7, 6, 3},
                {6, 6, 1}
        }, 18));
    }

    public static int countSubmatrices(int[][] grid, int k) {
        int rows = grid.length, cols = rows > 0 ? grid[0].length : 0;
        int count = 0;
        int[][] left = new int[rows][cols], top = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col == 0) {
                    left[row][col] = grid[row][col];
                } else {
                    left[row][col] = grid[row][col] + left[row][col - 1];
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0) {
                    top[row][col] = left[row][col];
                } else {
                    top[row][col] = left[row][col] + top[row - 1][col];
                }
            }
        }


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                count += top[row][col] <= k ? 1 : 0;
            }
        }
        return count;
    }

}
