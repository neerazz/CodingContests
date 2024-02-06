package weekly.weekly383;

/**
 * Created on:  February 3, 2024, 9:30 PM
 * Ref: <a href="https://leetcode.com/contest/weekly-contest-383">AntOnTheBoundary</a>
 */

public class AntOnTheBoundary {

    public static void main(String[] args) {

    }

    public static int returnToBoundaryCount(int[] nums) {
        int count = 0, score = 0;
        for (int num : nums) {
            score += num;
            if (score == 0) count++;
        }
        return count;
    }

}
