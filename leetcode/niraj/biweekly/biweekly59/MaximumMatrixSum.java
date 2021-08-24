package biweekly.biweekly59;

/**
 * Created on:  Aug 21, 2021
 * Ref : https://leetcode.com/contest/biweekly-contest-59/problems/maximum-matrix-sum/
 */
public class MaximumMatrixSum {
    public static void main(String[] args) {
        System.out.println(maxMatrixSum(new int[][]{{1, -1}, {-1, 1}}));
    }

    static long max;

    //    https://leetcode.com/problems/maximum-matrix-sum/discuss/1417606/C%2B%2B-The-basic-idea-is-to-eliminate-negative-signs
    public static long maxMatrixSum(int[][] matrix) {
        long sum = 0, min = Integer.MAX_VALUE, neg = 0;
        for (int[] cols : matrix) {
            for (int cur : cols) {
                sum += Math.abs(cur);
                if(cur < 0){
                    neg++;
                    cur *= -1;
                }
                min = Math.min(min, cur);
            }
        }
        if (neg % 2 == 0) return sum;
//        Since there is odd number of neg, we have to swap in such a way that the min negative number is left out.
//        Subtract min number 2 times, because it as added to sum when adding the abs, and then the remaining negative number.
        return sum - min - min;
    }
}
