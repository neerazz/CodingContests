package biweekly.biweekly62;

/**
 * Created on:  Oct 02, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-62/problems/convert-1d-array-into-2d-array/
 */

public class Convert1DArrayInto2DArray {

    public static void main(String[] args) {

    }

    public int[][] construct2DArray(int[] original, int m, int n) {
        int l1 = original.length;
        if(m*n != l1) return new int[0][0];
        int[][] result = new int[m][n];
        int row =0, col = 0, i =0;
        while(row < m && col < n){
            result[row][col] = original[i++];
            col++;
            if(col == n){
                row++;
                col =0;
            }
        }
        return result;
    }
}
