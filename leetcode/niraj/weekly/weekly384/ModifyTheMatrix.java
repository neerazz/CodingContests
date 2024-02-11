package weekly.weekly384;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on:  February 11, 2024, 11:44 AM
 * Ref: <a href="https://leetcode.com/contest/weekly-contest-384">ModifyTheMatrix</a>
 */

public class ModifyTheMatrix {

    public static void main(String[] args) {

    }

    public int[][] modifiedMatrix(int[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] result = new int[rows][cols];
        for (int col = 0; col < cols; col++) {
            int max = Integer.MIN_VALUE;
            List<int[]> idxs = new ArrayList<>();
            for (int row = 0; row < rows; row++) {
                int num = matrix[row][col];
                if (num == -1) {
                    idxs.add(new int[]{row, col});
                }
                result[row][col] = matrix[row][col];
                max = Math.max(max, num);
            }
            for (int[] idx : idxs) {
                result[idx[0]][idx[1]] = max;
            }
        }
        return result;
    }

}
