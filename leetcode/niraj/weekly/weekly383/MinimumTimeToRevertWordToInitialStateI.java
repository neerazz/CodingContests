package weekly.weekly383;

/**
 * Created on:  February 3, 2024, 9:30 PM
 * Ref: <a href="https://leetcode.com/contest/weekly-contest-383">MinimumTimeToRevertWordToInitialStateI</a>
 */

public class MinimumTimeToRevertWordToInitialStateI {

    public static void main(String[] args) {

    }

    public static int minimumTimeToInitialState(String word, int k) {
        int len = word.length(), maxPos = len / k + (len % k > 0 ? 1 : 0);
        int count = 0;
        for (int i = k; i < len; i = i + k) {
            count++;
            String string = word.substring(i);
            if (canFormString(word, string)) {
                return count;
            }
        }
        return maxPos;
    }

    private static boolean canFormString(String word, String subStr) {
        for (int i = 0; i < subStr.length(); i++) {
            if (word.charAt(i) != subStr.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
